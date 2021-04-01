package com.ruchi.frontendProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ruchi.backendProject.dao.UserDAO;
import com.ruchi.backendProject.dto.User;
import com.ruchi.frontendProject.model.UserModel;

@ControllerAdvice
public class globalController 
{
	@Autowired
	private HttpSession session;
	
	private User user;
	private UserModel userModel;
	
	@Autowired
	private UserDAO userDAO;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() 
	{
		if(session.getAttribute("userModel")== null ) // if userModel is present in session object or not
		{
			// if not present ,add new userModel
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // to check the authentication of userModel
             
			//extracting the userfrom database by emailId.
			user = userDAO.getByEmail(authentication.getName());
			
			if(user!=null)// to check user is present or not
			{
				// create a new usermodel
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setRole(user.getRole());
				userModel.setFullname(user.getFirstName() + " " + user.getLastName());
				
				if(userModel.getRole().equals("USER"))// checking userMode is user or admin
				{
					userModel.setCart(user.getCart()); // only for user
				}
				
				// add the userModel to the session.
				session.setAttribute("userModel",userModel );
				return userModel;
			}	
		 }
		
		// return the userMode if it is already present.
			return (UserModel) session.getAttribute("userModel");
	}
}
