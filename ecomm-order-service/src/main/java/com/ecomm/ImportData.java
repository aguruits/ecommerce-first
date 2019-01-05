package com.ecomm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecomm.model.order.Order;
import com.ecomm.service.OrderService;

@Component
public class ImportData implements CommandLineRunner {

	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	OrderService orderService;
	
	@Override
	public void run(String... arg0) throws Exception {
		List<Order> orderList = initData();
		
		int i = 1;		
		for(Order order: orderList) {			
			logger.info("*****Insert Record***** " + i);
			orderService.saveOrder(order);
			i++;
		}	
		
	}
	
	private List<Order> initData() {
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1, 1, 5, 10, 100.00f,500.00f));
		orders.add(new Order(2, 1, 2, 3, 70.00f, 210.00f));
		orders.add(new Order(3, 2, 1, 10, 70.00f, 700.00f));
		orders.add(new Order(4, 2, 2, 50, 50.00f, 2500.00f));
		
		return orders;
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
		List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM ECOMM_USERS;");
		logger.info("***** System has " + users.size() + " Users");

		return dataSource;
	}*/
}
