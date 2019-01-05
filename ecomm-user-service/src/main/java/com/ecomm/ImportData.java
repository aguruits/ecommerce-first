package com.ecomm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecomm.model.User;
import com.ecomm.service.UserService;

@Component
public class ImportData implements CommandLineRunner {

	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	UserService userService;
	
	@Override
	public void run(String... arg0) throws Exception {
		List<User> userList = initData();
		
		int i = 1;		
		for(User user: userList) {			
			logger.info("*****Insert Record***** " + i);
			userService.saveUser(user);
			i++;
		}	
		
	}
	
	private List<User> initData() {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "Guru", 1, "123", "EMPLOYEE"));
		userList.add(new User(2, "Murthy", 1, "123", "MANAGER"));
		return userList;
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
