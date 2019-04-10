package com.huongdanjava.springcloudturbinestreamservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class SpringCloudTurbineStreamService3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTurbineStreamService3Application.class, args);
	}

}
