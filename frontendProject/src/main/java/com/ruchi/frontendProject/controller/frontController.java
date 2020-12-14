package com.ruchi.frontendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ruchi.backendProject.daoimpl.CategoryDAOimpl;

@Controller
public class frontController 
{
	@Autowired
	public CategoryDAOimpl categoryDAO;
	
 @RequestMapping(value={"/","/home","/index"})
 public ModelAndView index()
 { 
	 
	 ModelAndView mav = new ModelAndView("page");
	 
	 mav.addObject("title","Home");
	 mav.addObject("ClickHome",true);
	 mav.addObject("categories",categoryDAO.categoryList());
	 
	 
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
 
 @RequestMapping(value={"/services",})
 public ModelAndView services()
 { 
	 
	 ModelAndView mav = new ModelAndView("page");
	 
	 mav.addObject("title","Services");
	 mav.addObject("ClickServices",true);
	 return mav;
 } 
 

}

