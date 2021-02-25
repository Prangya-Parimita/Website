package com.ruchi.backendProject.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruchi.backendProject.dao.CategoryDAO;
import com.ruchi.backendProject.dto.Category;

public class testCategory 
{
	
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ruchi.backendProject");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("CategoryDAO");
	}	
	
	
	
   @Test
	public void testInsert()
	{
		category = new Category();
		category.setName("TELEVISION");
		category.setDesc("television category");
		category.setImageurl("Cat_1.png");
		assertEquals("Error inserting a new row into the category Table",true,categoryDAO.insert(category));
		
		//true is the boolean expression
		category = new Category();
		category.setName("AIR CONDITION");
		category.setDesc("air condition category");
		category.setImageurl("Cat_2.png");
		assertEquals("Error inserting a new row into the category Table",true,categoryDAO.insert(category));
		  
		category = new Category();
		category.setName("PHONE");
		category.setDesc("phone category");
		category.setImageurl("Cat_3.png");
		assertEquals("Error inserting a new row into the category Table",true,categoryDAO.insert(category));
		 
		category = new Category();
		category.setName("LIGHT");
		category.setDesc("light category");
		category.setImageurl("Cat_4.png");
		assertEquals("Error inserting a new row into the category Table",true,categoryDAO.insert(category));
		 
	}
   
	
	
	/*@Test
	public void testUpdate()
	{
		category = categoryDAO.getCategory(1);//getcategory will return a single category from DB & 1 is the id
		
		category.setName("TELEVISION");
		assertEquals("Error updating a record into the category Table",true,categoryDAO.update(category));
		
		//assertEquals is to test equality of two objects
	}*/
	
	
	/*@Test  //single row is getting extracted
	public void testGetCategory()
	{	
		
		category = categoryDAO.getCategory(1);//extracted category is same as name provided of the given category
		

		assertEquals("Error extracting a single record from the category table","TELEVISION",category.getName());
		                                                              //product name ,method getName
		
	}*/
	
	/*@Test
	 public void testDelete()
	{	
		
		category = categoryDAO.getCategory(3);
		

		assertEquals("Error updating  a record in the category table",true,categoryDAO.delete(category));
		                                                              
		
	}*/
 	
/*	@Test
	public void testListCategory()
	{
 	  assertEquals("Error fetching the category list from category table!",4,categoryDAO.categoryList().size()); 
 	}*/
}
