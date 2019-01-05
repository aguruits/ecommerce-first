package com.ecomm.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.exception.EcommException;
import com.ecomm.model.order.Order;
import com.ecomm.model.order.OrderResponse;
import com.ecomm.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderEndpoint {

		@Autowired
		OrderService orderService;
		
		@GetMapping("/getOrders")
		public List<Order> getOrderList() {
			return orderService.getOrderList();
		}

		@GetMapping("/getOrder/{orderId}")
		public OrderResponse getOrder(@PathVariable("orderId") int orderId) {
			
			Order order = new Order();
			
			order = orderService.getOrder(orderId);
			
			OrderResponse responseMessage = new OrderResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Order Found.");
			responseMessage.setOrder(order);
			
			return responseMessage;
		}

		@PostMapping("/addOrder")
		public OrderResponse addOrder(@RequestBody Order order) {
			
			try { 
				this.orderService.saveOrder(order);
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while inserting order details into the Table");
			}
			
			OrderResponse responseMessage = new OrderResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Order hase been inserted successfully.");
			return responseMessage;
		}
		
		@PutMapping("/updateOrder")
		public OrderResponse updateOrder(@RequestBody Order order) {
			
			try { 
				this.orderService.updateOrder(order);
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while updating order details.");
			}
			
			OrderResponse responseMessage = new OrderResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Order details updated successfully.");
			return responseMessage;
		}

		@DeleteMapping("/deleteOrder/{orderId}")
		public OrderResponse deleteOrder(@PathVariable("orderId") int orderId) {
			
			try { 
				this.orderService.deleteOrder(orderId);;
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while deleting order details.");
			}
			
			OrderResponse responseMessage = new OrderResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Order details has been deleted successfully.");
			return responseMessage;
		}
	}

