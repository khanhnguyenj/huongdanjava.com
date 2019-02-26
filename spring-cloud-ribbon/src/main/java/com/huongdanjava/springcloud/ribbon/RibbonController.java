package com.huongdanjava.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/load-balancing")
	String loadBalancing() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("Eureka Client Example");

		return serviceInstance.getUri().toString();
	}
}
