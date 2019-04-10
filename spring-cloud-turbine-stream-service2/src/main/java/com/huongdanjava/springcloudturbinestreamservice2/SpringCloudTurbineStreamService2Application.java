package com.huongdanjava.springcloudturbinestreamservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class SpringCloudTurbineStreamService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTurbineStreamService2Application.class, args);
	}

}
