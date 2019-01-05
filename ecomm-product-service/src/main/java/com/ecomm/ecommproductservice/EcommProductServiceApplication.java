package com.ecomm.ecommproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommProductServiceApplication.class, args);
	}
	
}
