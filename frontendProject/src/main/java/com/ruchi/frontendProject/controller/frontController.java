package com.ruchi.frontendProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ruchi.backendProject.dao.CategoryDAO;
import com.ruchi.backendProject.dao.ProductDAO;
import com.ruchi.backendProject.dto.Category;
import com.ruchi.backendProject.dto.Product;


@Controller
public class frontController 
{    
	private static final Logger logger = LoggerFactory.getLogger(frontController.class);
	@Autowired
	public CategoryDAO CategoryDAO;
	
	@Autowired
	public ProductDAO productDAO;
	
	
    @RequestMapping(value={"/","/home","/index"})
    public ModelAndView index()
    { 
       logger.info("Inside frontController index method - INFO");
	   logger.debug("Inside frontController index method - DEBUG");
	   
	   ModelAndView mav = new ModelAndView("page");
	 
	   mav.addObject("title","Home");
	   mav.addObject("ClickHome",true);
	   mav.addObject("categories",CategoryDAO.categoryList());
	 
	   return mav;
 } 
 
    @RequestMapping(value={"/about",})
    public ModelAndView about()
     { 
	 
	   ModelAndView mav = new ModelAndView("page");
	 
	   mav.addObject("title","About us");
	   mav.addObject("ClickAbout",true);
	   return mav;
     } 
 
   @RequestMapping(value={"/contact",})
   public ModelAndView contact()
     { 
	 
	  ModelAndView mav = new ModelAndView("page");
	 
	  mav.addObject("title","Contact us");
	  mav.addObject("ClickContact",true);
	  return mav;
     } 
 
   @RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts()
   {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "All Products");
		mav.addObject("categories", CategoryDAO.categoryList());
		mav.addObject("userClickAllProducts", true);
		return mav;
	}

	@RequestMapping(value = "/show/category/{id}/product")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mav = new ModelAndView("page");
		Category category;
		category = CategoryDAO.getCategory(id);
		mav.addObject("title", category.getName());
		mav.addObject("categories", CategoryDAO.categoryList());
		mav.addObject("category", category);

		mav.addObject("userClickCategoryProduct", true);

		return mav;
	}

	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProducts(@PathVariable("id") int id) // url 
	{
		ModelAndView mav = new ModelAndView("page");
		
		Product product = productDAO.getProduct(id);//exraction of product from products list
		
		product.setViews(product.getViews() + 1);  // increment of views in database table 
		productDAO.updateProduct(product);         //update product in database and return 
		
		mav.addObject("title", product.getName());  //product name will return
		mav.addObject("product",product);          // product details
		
		mav.addObject("userClickSingleProduct",true);  // adding button and testing parameter
		return mav;
	}
	

}

