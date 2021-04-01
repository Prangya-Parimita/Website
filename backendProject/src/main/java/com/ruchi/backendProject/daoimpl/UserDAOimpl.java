package com.ruchi.backendProject.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ruchi.backendProject.dao.UserDAO;
import com.ruchi.backendProject.dto.Address;
import com.ruchi.backendProject.dto.Cart;
import com.ruchi.backendProject.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOimpl implements UserDAO {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) 
		{
			try 
			{			
				sessionFactory.getCurrentSession().persist(user);			
				return true;
			}
			catch(Exception ex) 
			{
				return false;
			}
	
	}

	@Override
	public boolean addAddress(Address address) 
	{
		try 
		{			
			sessionFactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}

	}	
	
	@Override
	public boolean updateCart(Cart cart) 
	{
		try 
		{			
			sessionFactory.getCurrentSession().update(cart);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}

	}	
	@Override
	public User getByEmail(String email)  // one user can have only one emailid
	{
		String selectQuery = "FROM User WHERE email = :email";
		try 
		{
		return sessionFactory.getCurrentSession()
					         .createQuery(selectQuery,User.class)
						     .setParameter("email",email)// as email id can only be 1 thats why we are using getSingleResult()
							 .getSingleResult(); 
		}
		
		catch(Exception ex) 
		{
			return null;
		}
	}
	
	@Override
	public Address getBillingAddress(int userId)
	{
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try
		  {
		       return sessionFactory.getCurrentSession()
					                .createQuery(selectQuery,Address.class)
						            .setParameter("userId", userId)
						            .setParameter("isBilling", true)// billing address is one thats why we are using getSingleResult()
						            .getSingleResult();
		 }
		    catch(Exception ex)
		 {
			return null;
		 }
	}	
	@Override
	public List<Address> listShippingAddresses(int userId) 
	{
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return sessionFactory.getCurrentSession()
					         .createQuery(selectQuery,Address.class)
						     .setParameter("userId", userId)
						     .setParameter("isShipping", true)//as shipping address can multiple thats wey using getResultList()
						     .getResultList();
		
	}

	@Override
	public Address getAddress(int addressId) {
		try {			
			return sessionFactory.getCurrentSession().get(Address.class, addressId);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	
}
