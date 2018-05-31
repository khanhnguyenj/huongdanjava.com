package com.huongdanjava.springcloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDiscoveryApplication.class, args);
	}
}
