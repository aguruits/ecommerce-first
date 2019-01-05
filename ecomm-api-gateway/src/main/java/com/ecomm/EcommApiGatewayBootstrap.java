package com.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableHystrix
@EnableHystrixDashboard 
public class EcommApiGatewayBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(EcommApiGatewayBootstrap.class, args);
	}

}

