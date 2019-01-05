package com.ecomm.model;

import java.util.Date;

public class Product {
	
	private Integer productId;
	private String productCode;
	private String name;
	private float price;
	private Integer availableQuantity;
	private Date createDate;
	
	public Product() {
		
	}
	public Product(Integer productId, String productCode, String name, float price, Integer availableQuantity, Date createDate) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.createDate = createDate;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
