package com.ecomm.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.dao.OrderEntity;
import com.ecomm.dao.OrderRepository;
import com.ecomm.exception.EcommException;
import com.ecomm.model.order.CreateOrder;
import com.ecomm.model.order.Order;
import com.ecomm.model.order.OrderResponse;
import com.ecomm.model.product.Product;
import com.ecomm.model.product.ProductResponse;
import com.ecomm.model.user.User;
import com.ecomm.model.user.UserResponse;

@Service
public class CreateOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductContract productContract;
	
	@Autowired
	private UserContract userContract;
	
	@Autowired
	private OrderService orderService;

	protected final Logger logger = Logger.getLogger(getClass());
	
	public OrderResponse createOrder(Order order) throws Exception {
		
		logger.info("*****createOrder*****");
		OrderResponse orderResponse = new OrderResponse();
		User user = getUser(order.getUserId());
		Product product = getProduct(order.getProductId());
		
		int order_quanity = order.getQuantity();
		int available_quanity = product.getAvailableQuantity();
		
		if(order_quanity > available_quanity) {
			logger.info("***** Your order qunity: "+ order_quanity +" is be greater than available quantity: "+ available_quanity +"*****");
			
			orderResponse.setResponeStatus("Success");
			orderResponse.setResponseCode("01");
			orderResponse.setResponseDesc("Your order qunity is be greater than available quantity");			
		} else {
			// Create Order
			orderService.saveOrder(order);
			logger.info("*****Order Created Successfull*****");
			
			int quantity = available_quanity - order_quanity;
			product.setAvailableQuantity(quantity);;
			
			// Update product available quantity
			ProductResponse productResponse = updateProduct(product) ;
			if(productResponse != null ) {
				String responseCode = productResponse.getResponseCode();
				if(StringUtils.isNotBlank(responseCode) && StringUtils.equalsIgnoreCase("00", responseCode)) {
					logger.info("*****Product availble quantity has been updated successfully*****");
				} else {
					logger.info("*****Product availble quantity has not been updated*****");
				}
			}
			
			orderResponse.setResponseCode("00");
			
		}
		return orderResponse;
	}
	
	public Product getProduct(Integer productId) throws Exception {
		Product product = new Product();
		ProductResponse productResponse = new ProductResponse();
		if(productId == null) {
			logger.info("*****productId should not be null*****");
			throw new EcommException("productId should not be null.");
		} else {
			logger.info("*****Call product service to get product Details*****");
			productResponse = productContract.getProduct(productId);
			String errorStatus = productResponse.getResponseCode();
			if(StringUtils.isNotBlank(errorStatus) && !StringUtils.equalsIgnoreCase(errorStatus, "00")) {
				logger.info("*****"+productResponse.getResponseDesc()+"*****");
				throw new EcommException("productId should not be null.");
			} else {
				product = productResponse.getProduct();
			}
		}
		
		return product;		
	}
	
	
	public ProductResponse updateProduct(Product product) throws Exception {
		ProductResponse productResponse = new ProductResponse();
		
		productResponse = productContract.updateProduct(product);
		
		return productResponse;		
	}
	
	public User getUser(Integer userId) throws Exception {
		User user = new User();
		UserResponse userResponse = new UserResponse();
		if(userId == null) {
			logger.info("*****userId should not be null*****");
			throw new EcommException("productId should not be null.");
		} else {
			logger.info("*****Call user service to get user Details*****");
			userResponse = userContract.getUser(userId);
			if(userResponse != null ) {
				String responseCode = userResponse.getResponseCode();
				if(StringUtils.isNotBlank(responseCode) && StringUtils.equalsIgnoreCase("00", responseCode)) {
					user = userResponse.getUser();
				}
			}
		}
		
		return user;		
	}
	
}
