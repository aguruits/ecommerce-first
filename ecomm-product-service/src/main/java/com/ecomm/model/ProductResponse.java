package com.ecomm.model;

public class ProductResponse {
	
	public String responseCode;
	public String responseDesc;
	public String responeStatus;
	public Product product;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDesc() {
		return responseDesc;
	}
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}
	public String getResponeStatus() {
		return responeStatus;
	}
	public void setResponeStatus(String responeStatus) {
		this.responeStatus = responeStatus;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
