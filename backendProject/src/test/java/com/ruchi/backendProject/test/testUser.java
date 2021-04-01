package com.ruchi.backendProject.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruchi.backendProject.dao.UserDAO;
import com.ruchi.backendProject.dto.Address;
import com.ruchi.backendProject.dto.Cart;
import com.ruchi.backendProject.dto.User;



public class testUser 
{
private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user ;
	private Address address ;
	private Cart cart;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ruchi.backendProject");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}	
	
  @Test
	public void testAddUser() 
	{
		
     	user = new User() ;
		user.setFirstName("Ram");
		user.setLastName("Kumar");
		user.setEmail("rak@gmail.com");
		user.setContactNumber("9437145567");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		assertEquals("Failed to add the user!", true, userDAO.addUser(user)); //add user
		
	}
		
	/*	address = new Address();
		address.setAddressLineOne("ircon tower,newtown");
		address.setAddressLineTwo("opposite reliance fresh");
		address.setCity("Kolkata");
		address.setState("WestBengal");
		address.setCountry("India");
		address.setPostalCode("600001");
		address.setBilling(true);
		
		address.setUserId(user.getId());    // link the address with user 
			
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));// add  billing address
		
		
		if(user.getRole().equals("USER"))
		{
		
			cart = new Cart();
		
			//cart.setUserId(user.getId());
			 
			cart.setUser(user); //we can use only after removing UserId from address and card for one to one link with user
			
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
	
			address = new Address();
			address.setAddressLineOne("ircon tower,newtown");
			address.setAddressLineTwo("opposite reliance fresh");
			address.setCity("Kolkata");
			address.setState("WestBengal");
			address.setCountry("India");
			address.setPostalCode("600001");
			address.setShipping(true);
			address.setUserId(user.getId());
		
			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		}
		
	}
   
 	@Test
	public void testAddUser()
	{
		user = new User() ;
		user.setFirstName("Anil");
		user.setLastName("Kumar");
		user.setEmail("ak@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
	
	
		if(user.getRole().equals("USER"))
		{
			cart = new Cart();
	
			cart.setUser(user);//setting the user property in cart 
		
			user.setCart(cart);// setting the cart property in user
	
		}
	
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
	
	}*/
	
	
	/*@Test
	public void testUpdateCart() 
	{
		user = userDAO.getByEmail("ak@gmail.com");
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(2);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	}*/
	
	/* @Test
		public void testAddUser() 
		{
			
	     	user = new User() ;
			user.setFirstName("raj");
			user.setLastName("Kumar");
			user.setEmail("raj@gmail.com");
			user.setContactNumber("1234567478");
			user.setRole("USER");
			user.setEnabled(true);
			user.setPassword("12345");
			
			assertEquals("Failed to add the user!", true, userDAO.addUser(user)); 
			
			
			
			if(user.getRole().equals("USER"))
			{
				cart = new Cart();
		
				cart.setUser(user);
			
				user.setCart(cart);
		
			}	
			
			address = new Address();
			address.setAddressLineOne("talpali para,balangir");
			address.setAddressLineTwo("near chandraseni mandir");
			address.setCity("balangir");
			address.setState("odisha");
			address.setCountry("India");
			address.setPostalCode("767001");
			address.setBilling(true);
				
			assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
			
		
				address = new Address();
				address.setAddressLineOne("hatisal para,bargaon");
				address.setAddressLineTwo("opposite shiv mandir");
				address.setCity("bargaon");
				address.setState("Odisha");
				address.setCountry("India");
				address.setPostalCode("756001");
				address.setShipping(true);
				
			
				assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
			}*/
			
	}

