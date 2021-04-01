package com.ruchi.frontendProject.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruchi.backendProject.dao.CartLineDAO;
import com.ruchi.backendProject.dao.ProductDAO;
import com.ruchi.backendProject.dao.UserDAO;
import com.ruchi.backendProject.dto.Address;
import com.ruchi.backendProject.dto.Cart;
import com.ruchi.backendProject.dto.CartLine;
import com.ruchi.backendProject.dto.OrderDetail;
import com.ruchi.backendProject.dto.OrderItem;
import com.ruchi.backendProject.dto.Product;
import com.ruchi.backendProject.dto.User;
import com.ruchi.frontendProject.model.CheckoutModel;
import com.ruchi.frontendProject.model.UserModel;

@Component("checkoutHandler")
public class CheckOutHandler 
 {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	public List<Address> getShippingAddresses(CheckoutModel model) 
	{
		
		List<Address> addresses = userDAO.listShippingAddresses(model.getUser().getId());
		
		if(addresses.size() == 0) {
			addresses = new ArrayList<>();
		}

		addresses.add(addresses.size(), userDAO.getBillingAddress(model.getUser().getId()));			
		
		return addresses;
		
	}
	
	public CheckoutModel init(String name) throws Exception{

		User user = userDAO.getByEmail(name);
		System.out.println("User Id : " + user.getId());
		CheckoutModel checkoutModel = null;	

		if(user!=null)
		{
			checkoutModel = new CheckoutModel();
			checkoutModel.setUser(user);
			checkoutModel.setCart(user.getCart());
			
			double checkoutTotal = 0.0;
			List<CartLine> cartLines = cartLineDAO.listAvailable(user.getCart().getId());

			if(cartLines.size() == 0 ) {
				throw new Exception("There are no products available for checkout now!");
			}
			
			for(CartLine cartLine: cartLines) {
				checkoutTotal += cartLine.getTotal();
			}
			
			checkoutModel.setCartLines(cartLines);
			checkoutModel.setCheckoutTotal(checkoutTotal);			
		}			
		
		return checkoutModel;
	}
	
	public String saveAddressSelection(CheckoutModel checkoutModel, int shippingId) {

		String transitionValue = "success";
		
		Address shipping = userDAO.getAddress(shippingId);		
		
		checkoutModel.setShipping(shipping);
		
		return transitionValue;
		
	}
	

	public String saveAddress(CheckoutModel checkoutModel, Address shipping) {

		String transitionValue = "success";
		
		shipping.setUserId(checkoutModel.getUser().getId());  // set the user id
		shipping.setShipping(true);     // set shipping as true
		userDAO.addAddress(shipping);
		
		checkoutModel.setShipping(shipping);     // set the shipping id to flowScope object
		
		return transitionValue;
		
	}
	
	public String saveOrder(CheckoutModel checkoutModel) {
		String transitionValue = "success";	
		
		
		OrderDetail orderDetail = new OrderDetail();// create a new order object
				 
		orderDetail.setUser(checkoutModel.getUser());// attach the user
				
		orderDetail.setShipping(checkoutModel.getShipping()); // attach the shipping address
		
		Address billing = userDAO.getBillingAddress(checkoutModel.getUser().getId());	// fetch the billing address
	
		orderDetail.setBilling(billing);

		List<CartLine> cartLines = checkoutModel.getCartLines();
		OrderItem orderItem = null;
		
		double orderTotal = 0.0;
		int orderCount = 0;
		Product product = null;
		
		for(CartLine cartLine : cartLines) {
			
			orderItem = new OrderItem();
			
			orderItem.setBuyingPrice(cartLine.getBuyingPrice());
			orderItem.setProduct(cartLine.getProduct());
			orderItem.setProductCount(cartLine.getProductCount());
			orderItem.setTotal(cartLine.getTotal());
			
			orderItem.setOrderDetail(orderDetail);
			orderDetail.getOrderItems().add(orderItem);
			
			orderTotal += orderItem.getTotal();
			orderCount++;
			
			
			// reduce the quantity of product
			product = cartLine.getProduct();
			product.setQuantity(product.getQuantity() - cartLine.getProductCount());// update the product
			product.setPurchases(product.getPurchases() + cartLine.getProductCount());
			productDAO.updateProduct(product);
			
			// delete the cartLine
			cartLineDAO.remove(cartLine);
			

			
		}
		
		orderDetail.setOrderTotal(orderTotal);
		orderDetail.setOrderCount(orderCount);
		orderDetail.setOrderDate(new Date());
		
		// save the order
		cartLineDAO.addOrderDetail(orderDetail);

		// set it to the orderDetails of checkoutModel
		checkoutModel.setOrderDetail(orderDetail);

		//add the cart details to cart history
		
		// update the cart
		Cart cart = checkoutModel.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - orderTotal);
		cart.setCartLines(cart.getCartLines() - orderCount);
		cartLineDAO.updateCart(cart);
		
		// update the cart if its in the session
		UserModel userModel = (UserModel) session.getAttribute("userModel");
		if(userModel!=null) {
			userModel.setCart(cart);
		}
		
				
		return transitionValue;		
	}

	
	public OrderDetail getOrderDetail(CheckoutModel checkoutModel) {
		return checkoutModel.getOrderDetail();
	}
	
}
