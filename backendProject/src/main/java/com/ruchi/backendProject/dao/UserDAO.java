package com.ruchi.backendProject.dao;

import com.ruchi.backendProject.dto.Address;
import com.ruchi.backendProject.dto.Cart;
import com.ruchi.backendProject.dto.User;

public interface UserDAO 
{
	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean addCart(Cart cart);

}
