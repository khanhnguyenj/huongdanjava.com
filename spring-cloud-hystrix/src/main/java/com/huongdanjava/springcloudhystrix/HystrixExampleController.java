package com.huongdanjava.springcloudhystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixExampleController {

	@GetMapping("/call-hello")
	@HystrixCommand(fallbackMethod = "defaultCallHello")
	public String callHello() {
		return new RestTemplate().getForObject("http://localhost:8080/hello", String.class);
	}

	public String defaultCallHello() {
		return "Hello from Huong Dan Java!!!";
	}

}
