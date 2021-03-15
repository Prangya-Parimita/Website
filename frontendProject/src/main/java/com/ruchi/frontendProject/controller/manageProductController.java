package com.ruchi.frontendProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ruchi.backendProject.dao.CategoryDAO;
import com.ruchi.backendProject.dao.ProductDAO;
import com.ruchi.backendProject.dto.Category;
import com.ruchi.backendProject.dto.Product;
import com.ruchi.frontendProject.util.FileUtil;
import com.ruchi.frontendProject.validator.ProductValidate;


@Controller
@RequestMapping("/manage")
public class manageProductController
{    
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(manageProductController.class);
	
	@RequestMapping("/product")
	public ModelAndView manageProduct(@RequestParam(name="operation", required=false) String operation)
	{		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Manage Product");		
		mv.addObject("userClickManageProduct",true);
		 

		Product product = new Product();
		
		product.setSupplierId(1);
		product.setActive(true);

		mv.addObject("product", product);
		
		if(operation != null) 
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product submitted successfully!");
			}
			else
				if(operation.equals("category"))
				{
					mv.addObject("message", "Category submitted successfully!");
				}
		}
		return mv;
	}
	
	
	
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() 
	{
		return categoryDAO.categoryList();
	} 
	
	
	
	//Submit product
	@RequestMapping(value = "/product", method=RequestMethod.POST)      
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product newProduct,BindingResult results, Model model,HttpServletRequest request)
	{
		if(newProduct.getId() == 0)
		{
			new ProductValidate().validate(newProduct,results);
		}
		else
		{
			if(!newProduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidate().validate(newProduct,results);
			}
		}
		
				
		 if(results.hasErrors()) 
			{
				
				model.addAttribute("userClickManageProduct",true);
				model.addAttribute("title","Product Management");
				//model.addAttribute("message", "Validation fails for adding the product!");
				return "page";
			}
		  
		 if(newProduct.getId() == 0)
			{
				productDAO.insertProduct(newProduct);   //Inserting new product
			}
			else
			{
				productDAO.updateProduct(newProduct);
			}
			
		 
		 
	     if(!newProduct.getFile().getOriginalFilename().equals("") )
		   {
			    FileUtil.uploadFile(request, newProduct.getFile(), newProduct.getCode()); 
		   }
		
		    logger.info(newProduct.toString());
		    logger.debug("Inside PageController index method - DEBUG");
		
		  return "redirect:/manage/product?operation=product";
	}
	
	
	
	// Active or Deactivation
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST) // no need to mention manage as it has already defined
	@ResponseBody
	public String handleProductAvtivation(@PathVariable int id)
	{
		Product product = productDAO.getProduct(id);   //extracting the product with id using getProduct()
		
		boolean isActive = product.isActive();         // passing isActive parameter
		
		product.setActive(!isActive);                 // deactivating
		
		productDAO.updateProduct(product);	          // updating product
		
		
		return (isActive)?                            // passing checkbox
				"Successfully Deactivated the product : " +product.getId()
				: "Successfully Activated the product : " +product.getId();
	}
	
	
	@RequestMapping(value = "/{id}/product", method=RequestMethod.GET) //for edit product
	public ModelAndView handleProductEdit(@PathVariable int id)
	{
		
		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProduct",true);
		
		Product product = productDAO.getProduct(id);
		
		mv.addObject("product", product);
		
		return mv;
	}
	
	
	@ModelAttribute("category")
	public Category modelCategory() 
	{
		return new Category();
	}
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String managePostCategory(@ModelAttribute("category") Category myCat) 
	{					
		
		myCat.setActive(true);
		
		categoryDAO.insert(myCat);
		
		return "redirect:/manage/product?operation=category";
	}

}
