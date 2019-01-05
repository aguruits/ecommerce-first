package com.ecomm.endpoint;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.exception.EcommException;
import com.ecomm.model.order.CreateOrder;
import com.ecomm.model.order.Order;
import com.ecomm.model.order.OrderResponse;
import com.ecomm.model.product.Product;
import com.ecomm.model.product.ProductResponse;
import com.ecomm.model.user.User;
import com.ecomm.model.user.UserResponse;
import com.ecomm.service.CreateOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/createOrder")
public class CreateOrderEndpoint {

	@Autowired
	CreateOrderService createOrderService;
	
	@HystrixCommand(fallbackMethod="createOrder_fallback")
	@PostMapping("/create")
	public OrderResponse createOrder(@RequestBody Order order) {
		
		OrderResponse responseMessage = new OrderResponse();
		
		try { 
			CreateOrder createOrder = new CreateOrder();
			createOrder.setOrder(order);
			
			responseMessage = createOrderService.createOrder(order);
			
			if(responseMessage!= null) {
				String responseCode = responseMessage.getResponseCode();
				if(StringUtils.equalsIgnoreCase("00", responseCode)) {
					responseMessage.setResponeStatus("Success");
					responseMessage.setResponseCode("00");
					responseMessage.setResponseDesc("Order hase been created successfully.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EcommException("Error occurred while inserting order details into the Table");
		}
		
		return responseMessage;
	}
	
	public OrderResponse createOrder_fallback(@RequestBody Order order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setResponseCode("ERR");
		orderResponse.setResponseDesc("Unable to create order, due to some of the service/s down");
		orderResponse.setResponeStatus("NOT CREATE");
		return orderResponse;		
	}
	
}

