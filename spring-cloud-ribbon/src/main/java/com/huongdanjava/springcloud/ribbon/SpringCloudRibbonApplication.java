package com.huongdanjava.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonApplication.class, args);
	}

}

