package com.ruchi.backendProject.dao;

import java.util.List;

import com.ruchi.backendProject.dto.Product;

public interface ProductDAO
{
	Product getProduct(int productId);
	List<Product> productList();	         //returning all the products whether its active or not
	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	List<Product> listActiveProducts();	    // only active
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
