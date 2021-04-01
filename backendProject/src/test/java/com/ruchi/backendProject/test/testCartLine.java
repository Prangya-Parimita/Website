package com.ruchi.backendProject.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruchi.backendProject.dao.CartLineDAO;
import com.ruchi.backendProject.dao.ProductDAO;
import com.ruchi.backendProject.dao.UserDAO;
import com.ruchi.backendProject.dto.Cart;
import com.ruchi.backendProject.dto.CartLine;
import com.ruchi.backendProject.dto.Product;
import com.ruchi.backendProject.dto.User;

public class testCartLine 
{
private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ruchi.backendProject");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("ProductDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	


	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("ri@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.getProduct(1);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(2);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
	}
	

}
