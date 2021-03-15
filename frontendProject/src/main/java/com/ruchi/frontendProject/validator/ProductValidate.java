package com.ruchi.frontendProject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ruchi.backendProject.dto.Product;

public class ProductValidate implements Validator {

	@Override
	public boolean supports(Class<?> productClass)            // need to work on product object and support specify validation.
	{
		
		return Product.class.equals(productClass);               // return product.
	}

	@Override
	public void validate(Object target, Errors errors)         // will define all validation
	{
		Product product = (Product) target;
		
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) // it raises any error if u have selected a file or not
		{
		
		  //errors.rejectValue(attribute name, error code, error message); these three parameters of rejectValue
			errors.rejectValue("file",  null  , "Please select a file to upload!");       // we will reject the value using error object
			return;
		}
       
		if(! (product.getFile().getContentType().equals("image/jpeg") || 
				product.getFile().getContentType().equals("image/png")) ||
				product.getFile().getContentType().equals("image/gif")
			 )
		{
				errors.rejectValue("file", null, "Please select an image file to upload!");
				return;	
		}
	}

}
