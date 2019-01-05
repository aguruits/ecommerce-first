package com.ecomm.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends UserRepositoryJDBCTemplate{
	
	private static final String PRODUCT_LIST = "SELECT USER_ID, USER_NAME, ACTIVE, PASSWORD, USER_ROLE FROM ECOMM_USERS ORDER BY orderId ASC";
	
	/*public List<User> getOrderList() {
		
		List<User> orderList = (List<User>) jdbcTemplate.query(PRODUCT_LIST, new BeanPropertyRowMapper<>(User.class));
		return orderList;
	}
	
	public User getOrderDetails(User product) {
		
		String product_code = product.getProductCode();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT USER_ID, USER_NAME, ACTIVE, PASSWORD, USER_ROLE ");
		sb.append("FROM ECOMM_USERS ");
		sb.append("WHERE PRODUCT_CODE = ? ");
		
		Object[] params = {product_code};
		int[] sqlTypes = {Types.VARCHAR};
		
		product = (User) jdbcTemplate.queryForObject(sb.toString(), params, sqlTypes, new BeanPropertyRowMapper<>(User.class));
		
		return product;
	}
	
	public int addOrderDetails(User product) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ECOMM_USERS VALUES (?, ?, ?, ?)");
		
		Object[] params = {product.getProductCode(), product.getName(), product.getPrice(), product.getCreateDate()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.FLOAT, Types.DATE};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}*/


}

