package com.ecomm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryJDBCTemplate {
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;
}
