package com.ecomm.model.order;

import com.ecomm.model.product.Product;
import com.ecomm.model.user.User;

public class CreateOrder {
	
	private Integer orderId;
	private Order order;
	private User user;
	private Product product;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
