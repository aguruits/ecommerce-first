package com.ecomm.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Product;

@Repository
public class ProductDAO extends ProductRepositoryJDBCTemplate{
	
	private static final String PRODUCT_LIST = "SELECT PRODUCT_CODE, NAME, PRICE, CREATE_DATE FROM ECOMM_PRODUCTS ORDER BY orderId ASC";
	
	public List<Product> getOrderList() {
		
		List<Product> orderList = (List<Product>) jdbcTemplate.query(PRODUCT_LIST, new BeanPropertyRowMapper<>(Product.class));
		return orderList;
	}
	
	public Product getOrderDetails(Product product) {
		
		String product_code = product.getProductCode();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT PRODUCT_CODE, NAME, PRICE, CREATE_DATE ");
		sb.append("FROM ECOMM_PRODUCTS ");
		sb.append("WHERE PRODUCT_CODE = ? ");
		
		Object[] params = {product_code};
		int[] sqlTypes = {Types.VARCHAR};
		
		product = (Product) jdbcTemplate.queryForObject(sb.toString(), params, sqlTypes, new BeanPropertyRowMapper<>(Product.class));
		
		return product;
	}
	
	public int addOrderDetails(Product product) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ECOMM_PRODUCTS VALUES (?, ?, ?, ?)");
		
		Object[] params = {product.getProductCode(), product.getName(), product.getPrice(), product.getCreateDate()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.FLOAT, Types.DATE};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}


}

