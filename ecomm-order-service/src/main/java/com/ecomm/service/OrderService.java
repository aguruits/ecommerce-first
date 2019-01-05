package com.ecomm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.dao.OrderEntity;
import com.ecomm.dao.OrderRepository;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.ResourceNotException;
import com.ecomm.model.order.Order;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	protected final Logger logger = Logger.getLogger(getClass());
	
	public List<Order> getOrderList() {
		
		logger.info("*****getOrderList*****");
		
		List<OrderEntity> orderEntities = orderRepository.findAll();
		
		List<Order> orders = new ArrayList<Order>();
		if(orderEntities != null && orderEntities.size()>0) {
			orders = orderEntities.stream()
						.map(oe -> new Order(oe.getOrderId(), oe.getUserId(), oe.getProductId(), oe.getQuantity(), oe.getPrice(), oe.getAmount()))
						.collect(Collectors.toList());
		}
		
		return orders;		
	}
	
	public Order getOrder(Integer orderId) {
		
		logger.info("*****OrderRepository***** orderId: " + orderId);
		Order order = new Order();
		
		if(orderId == null) {
			logger.info("*****getOrder***** orderId is null: ");
			throw new EcommException("Order Id should not be null.");
		} else {
		
			OrderEntity orderEntity = orderRepository.findOne(orderId);
			if(orderEntity != null) {
				BeanUtils.copyProperties(orderEntity, order);
			} else if(orderEntity == null) {	
				logger.info("*****OrderRepository***** No Order found for given orderId: " + orderId);
				throw new ResourceNotException("Order has not found for give order id: " + orderId);
			} 
		}
		return order;
	}
	
	public void saveOrder(Order order) throws Exception {
		logger.info("*****saveOrder*****");
		if(order == null) {
			logger.info("*****Order should not be null*****");
			throw new EcommException("OrderEntity should not be null.");
		} else {
			OrderEntity pe = new OrderEntity();
			BeanUtils.copyProperties(order, pe);
			this.orderRepository.save(pe);
			logger.info("*****updateOrder***** Order inserted successfully ");
		}
		
	}
	
	public void updateOrder(Order order) {
		
		logger.info("*****updateOrder*****");
		
		Integer orderId = order.getOrderId();
		logger.info("*****updateOrder***** orderId: " + orderId);
		if(orderId == null) {
			logger.info("*****getOrder***** orderId is null: ");
			throw new EcommException("Order Id should not be null.");
		} else {
			OrderEntity orderEntityDB = orderRepository.findOne(orderId);
			if(orderEntityDB == null)	{	
				logger.info("*****updateOrder***** No Order found for given orderId: " + orderId);
				throw new ResourceNotException("Order has not found for give order id: " + orderId);
			} else {
				OrderEntity orderEntity = new OrderEntity();
				BeanUtils.copyProperties(order, orderEntity);
				
				this.orderRepository.save(orderEntity);
				logger.info("*****updateOrder***** Order updated successfully ");
			}
		}
		
	}
	
	public void deleteOrder(Integer orderId) {
		
		logger.info("*****deleteOrder***** orderId: " + orderId);
		
		if(orderId == null) {
			logger.info("*****getOrder***** orderId is null: ");
			throw new EcommException("Order Id should not be null.");
		} else {
			OrderEntity orderEntity = orderRepository.findOne(orderId);
			if(orderEntity == null) {
				logger.info("*****OrderRepository***** No Order found for given orderId: " + orderId);
				throw new ResourceNotException("Order has not found for give order id: " + orderId);
			}
				
			this.orderRepository.delete(orderId);
			logger.info("*****updateOrder***** Order deleted successfully ");
		}
	}
}
