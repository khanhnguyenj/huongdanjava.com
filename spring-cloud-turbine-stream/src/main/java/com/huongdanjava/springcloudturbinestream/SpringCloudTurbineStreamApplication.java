package com.huongdanjava.springcloudturbinestream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
public class SpringCloudTurbineStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTurbineStreamApplication.class, args);
	}

}
