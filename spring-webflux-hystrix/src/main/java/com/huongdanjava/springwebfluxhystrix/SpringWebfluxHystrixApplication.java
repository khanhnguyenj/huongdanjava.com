package com.huongdanjava.springwebfluxhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class SpringWebfluxHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxHystrixApplication.class, args);
	}

}
