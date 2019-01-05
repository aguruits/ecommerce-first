package com.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceBootstrap {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "product");
		
		SpringApplication.run(ProductServiceBootstrap.class, args);
	}

}

