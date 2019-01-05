package com.ecomm.model;

public class User {
	
	private Integer userId;
	private String userName;
	private int active;
	private String password;
	private String userRole;
	
	public User() {
		
	}
	public User(Integer userId, String userName, int active, String password, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.active = active;
		this.password = password;
		this.userRole = userRole;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
