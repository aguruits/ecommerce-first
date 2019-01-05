package com.ecomm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecomm.model.Product;
import com.ecomm.service.ProductService;

@Component
public class ImportData implements CommandLineRunner {

	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	ProductService productService;
	
	@Override
	public void run(String... arg0) throws Exception {
		List<Product> productList = initData();
		
		int i = 1;		
		for(Product product: productList) {			
			logger.info("*****Insert Record***** " + i);
			productService.saveProduct(product);
			i++;
		}	
		
	}
	
	private List<Product> initData() {
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1, "S001", "Core Java", 100, 50, new Date()));
		productList.add(new Product(2, "S002", "Spring for Beginners", 50, 100, new Date()));
		productList.add(new Product(3, "S003", "Swift for Beginners", 120, 200, new Date()));
		productList.add(new Product(4, "S004", "Oracle XML Parser", 120, 30, new Date()));
		productList.add(new Product(5, "S005", "CSharp Tutorial for Beginers", 110, 60,new Date()));
		
		return productList;
	}

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
		List<Map<String, Object>> products = jdbcTemplate.queryForList("SELECT * FROM ECOMM_USERS;");
		logger.info("***** System has " + products.size() + " Products");

		return dataSource;
	}*/
}
