package com.ruchi.backendProject.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ruchi.backendProject.dao.CategoryDAO;
import com.ruchi.backendProject.dto.Category;

@Repository("CategoryDAO")
@Transactional

class CategoryDAOimpl implements CategoryDAO
{
	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public Category getCategory(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class,id);
	}

	@Override
	public List<Category> categoryList()
	{
		// used HQL
		String selectActiveCategory = "from Category where active = :active";
		 
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
				
		return query.getResultList();
	}

	@Override
	
	public boolean insert(Category category) 
	{
		try
		{  
			category.setActive(true);
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean update(Category category) {
		
		try
		{  
			category.setActive(true);
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) 
	{
		
	
		try
		{  
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	
	}
	
	
}
