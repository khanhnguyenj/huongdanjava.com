package com.huongdanjava.springcloudturbinestreamservice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Service2Controller {

	@GetMapping("/service2-call-hello")
	@HystrixCommand(fallbackMethod = "defaultCallHello")
	public String service2CallHello() {
		return new RestTemplate().getForObject("http://localhost:8082/hello", String.class);
	}

	public String defaultCallHello() {
		return "Hello from service 2!!!";
	}

}
