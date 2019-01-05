package com.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommUserBootstrap {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "user");
		
		SpringApplication.run(EcommUserBootstrap.class, args);
	}

}

