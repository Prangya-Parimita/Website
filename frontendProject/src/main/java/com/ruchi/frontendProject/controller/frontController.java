package com.ruchi.frontendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ruchi.backendProject.dao.CategoryDAO;
import com.ruchi.backendProject.dto.Category;


@Controller
public class frontController 
{
	@Autowired
	public CategoryDAO CategoryDAO;
	
    @RequestMapping(value={"/","/home","/index"})
    public ModelAndView index()
    { 
	 
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
	public ModelAndView showAllProducts() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "All Products");
		mav.addObject("categories", CategoryDAO.categoryList());
		mav.addObject("userClickAllProducts", true);
		return mav;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("page");
		Category category = null;
		category = CategoryDAO.getCategory(id);
		mav.addObject("title", category.getName());
		mav.addObject("categories", CategoryDAO.categoryList());
		mav.addObject("category", category);

		mav.addObject("userClickCategoryProducts", true);

		return mav;
	}

}

