package com.ecomm.model.user;

public class UserResponse {
	
	public String responseCode;
	public String responseDesc;
	public String responeStatus;
	public User user;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
