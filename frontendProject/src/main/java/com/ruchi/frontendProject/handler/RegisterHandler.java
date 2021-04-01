package com.ruchi.frontendProject.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ruchi.backendProject.dao.UserDAO;
import com.ruchi.backendProject.dto.Address;
import com.ruchi.backendProject.dto.Cart;
import com.ruchi.backendProject.dto.User;
import com.ruchi.frontendProject.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler
{
	
	 @Autowired
	 UserDAO userDAO;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	 public RegisterModel init()  // getting call before start
	 {
			return new RegisterModel();
	 }
	
     public void addUser(RegisterModel registerModel, User user) // getting called on the start flow
     {
 		registerModel.setUser(user);
 	 }
    
     public void addBilling(RegisterModel registerModel, Address billing) // billing flow
     {
    	 
    	registerModel.setBilling(billing);
 	 }

  

     public String saveAll(RegisterModel registerModel) // passing registerModel
     {
    	 String transitionValue = "success";
	     User user = registerModel.getUser(); //user object is passing into the registerModel 
	     if (user.getRole().equals("USER"))   // need to check the role of user
	     {
		    Cart cart = new Cart();           // need to add cart object
		    cart.setUser(user);              // importing cart and setting user and cart
		    user.setCart(cart);
		    
	     }
	     
	   //Encrypt the password
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
			
	     
	     userDAO.addUser(user);                 // calling add() and need to autowired useDAO
	     Address billing = registerModel.getBilling();
	    // billing.setUserId(user);
	     billing.setUserId(user.getId());
		 billing.setBilling(true);
		 userDAO.addAddress(billing);
		 return (transitionValue);
	}
     
	     
     
     public String validate(User user , MessageContext error)
 	{
 		String transitionValue = "success";
 		
 		if(!(user.getPassword().equals(user.getConfirmPassword())))
 		{
 			error.addMessage(new MessageBuilder()
 					.error()
 					.source("confirmPassword")
 					.defaultText("Confirm password does not match!")
 					.build());
 			
 			 transitionValue = "failure"; 
 			
 		}
 		
 		if((userDAO.getByEmail(user.getEmail()) != null) ) 
 		{
 			error.addMessage(new MessageBuilder()
 					.error()
 					.source("email")
 					.defaultText("Email Id is already taken!")
 					.build());
 			
 			transitionValue = "failure";
 		}
 		 
 		return transitionValue;
	
 	}
}
