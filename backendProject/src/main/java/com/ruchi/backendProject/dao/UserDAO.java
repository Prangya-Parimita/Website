package com.ruchi.backendProject.dao;

import java.util.List;

import com.ruchi.backendProject.dto.Address;
import com.ruchi.backendProject.dto.Cart;
import com.ruchi.backendProject.dto.User;

public interface UserDAO 
{
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean updateCart(Cart cart);
	
    User getByEmail(String email);                        // OneToOne mapping with use and cart and return type is user
    
    Address getBillingAddress(int userId);              // OneToMany and ManyToOne mapping with user and address and return typr is address
    
	List<Address> listShippingAddresses(int userId);// OneToMany and ManyToOne mapping with user and address
	
	Address getAddress(int addressId);

}
