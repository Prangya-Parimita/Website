package com.ruchi.backendProject.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ruchi.backendProject.dao.ProductDAO;
import com.ruchi.backendProject.dto.Product;

public class testProduct 
{
private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ruchi.backendProject");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("ProductDAO");
	}	

	/*@Test
	  public void testAddProduct()
	   {
		product = new Product();
		
		product.setName("Iphone12");
		product.setBrand("Apple");
		product.setDescription("it's a apple phone");
		product.setUnitPrice(65000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Error while inserting a new product!",true,productDAO.insertProduct(product));
		
		
        product = new Product();
		product.setName("Samsung S12");
		product.setBrand("Samsung");
		product.setDescription("it's a samsung phone");
		product.setUnitPrice(85000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Error while inserting a new product!",true,productDAO.insertProduct(product));
		
		product = new Product();
	    product.setName("Samsung 56inch TV");
	    product.setBrand("Samsung");
		product.setDescription("it's a samsung TV");
		product.setUnitPrice(90000);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(1);
		assertEquals("Error while inserting a new product!",true,productDAO.insertProduct(product));
			
		product = new Product();
	    product.setName("Lg AC");
	    product.setBrand("LG");
		product.setDescription("it's a LG AC");
		product.setUnitPrice(37000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		assertEquals("Error while inserting a new product!",true,productDAO.insertProduct(product));
			
	 }*/
	
	/*@Test
	public void testGetProduct()
	{
		product = productDAO.getProduct(3);
		
		assertEquals("Error extracting single product" , "Samsung 56inch TV",product.getName());
	}*/
	
	
	/*@Test
	public void testProductlist()
	{
		assertEquals("Error fetcheing the list of categories from the table!",4,productDAO.productList().size());
		
	}
	*/
	
	/*@Test
	public void testUpdateProduct()
	{
		product = productDAO.getProduct(2);
		product.setName("Samsung S7");
		assertEquals("Error while updating the existing record!",true,productDAO.updateProduct(product));
	}*/
	
	/*@Test
	public void testDeleteProduct()
	{
		product = productDAO.getProduct(2);
		assertEquals("Error deleting the existing record!",true,productDAO.deleteProduct(product));		
		
	}*/
	
 
	/*@Test
	public void testListActiveProducts() 
	{
		assertEquals("Error fetching the list of products!",4,productDAO.listActiveProducts().size());				
	}*/
	
	
	/*@Test
	public void testListActiveProductsByCategory() 
	{
			assertEquals("Error while fetching the list of products!",
					2,productDAO.listActiveProductsByCategory(3).size());
					
			assertEquals("Error while fetching the list of products!",
					1,productDAO.listActiveProductsByCategory(1).size());
	} 
	*/
	
	/*@Test
	public void testGetLatestActiveProduct() 
	{
			assertEquals("Error fetching the list of products!",3,productDAO.getLatestActiveProducts(3).size());
			
	}*/ 
}
