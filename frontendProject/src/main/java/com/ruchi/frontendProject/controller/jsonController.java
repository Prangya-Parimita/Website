package com.ruchi.frontendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruchi.backendProject.dao.ProductDAO;
import com.ruchi.backendProject.dto.Product;

@Controller
@RequestMapping( "json/data")
public class jsonController
{   
	@Autowired
    private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllActiveProducts()
	{
		return productDAO.listActiveProducts();
	}
	
	
	@RequestMapping("/category/{id}/product")
    @ResponseBody
    public List<Product>getProductByCategory(@PathVariable int id) 
    {
    	return productDAO.listActiveProductsByCategory(id);
    }
}
