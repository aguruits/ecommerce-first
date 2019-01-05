package com.ecomm.model.order;

public class OrderResponse {
	
	public String responseCode;
	public String responseDesc;
	public String responeStatus;
	public Order order;
	
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
