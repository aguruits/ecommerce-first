package com.ecomm.model.order;

public class Order {
	
	private Integer orderId;
	private Integer userId;
	private Integer productId;
	private Integer quantity;
	private float price;
	private float amount;
	
	public Order() {
		
	}

	public Order(Integer orderId, Integer userId, Integer productId, Integer quantity, float price, float amount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
