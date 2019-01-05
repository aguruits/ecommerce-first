package com.ecomm.web;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@PropertySource("classpath:db-config.properties")
public class ProductWebConfiguration {

	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * Creates an in-memory "rewards" database populated with test data for fast testing
	 */
	/*@Bean
	public DataSource dataSource() {
		logger.info("*****dataSource() invoked*****");

		// Create an in-memory H2 relational database containing some demo catalog and products.
		DataSource dataSource = (new EmbeddedDatabaseBuilder())
				 .setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:testDBData/data.sql").build();

		logger.info("*****dataSource = " + dataSource);

		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> products = jdbcTemplate.queryForList("SELECT * FROM ECOMM_PRODUCTS ");
		logger.info("***** System has " + products.size() + " PRODUCTS");

		return dataSource;
	}*/
}
