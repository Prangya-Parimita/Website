package com.ruchi.backendProject.dao;

import java.util.List;

import com.ruchi.backendProject.dto.Product;

public interface ProductDAO
{
	Product getProduct(int productId);
	List<Product> productList();	
	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
