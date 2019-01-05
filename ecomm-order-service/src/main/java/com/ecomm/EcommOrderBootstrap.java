package com.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableHystrixDashboard
public class EcommOrderBootstrap {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "order");
		
		SpringApplication.run(EcommOrderBootstrap.class, args);
	}

}

