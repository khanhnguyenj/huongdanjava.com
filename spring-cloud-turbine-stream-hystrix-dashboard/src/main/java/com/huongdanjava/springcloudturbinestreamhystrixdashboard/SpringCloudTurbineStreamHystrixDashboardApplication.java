package com.huongdanjava.springcloudturbinestreamhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudTurbineStreamHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTurbineStreamHystrixDashboardApplication.class, args);
	}

}
