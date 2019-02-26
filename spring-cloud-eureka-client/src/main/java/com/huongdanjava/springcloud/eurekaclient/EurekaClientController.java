package com.huongdanjava.springcloud.eurekaclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello !!!";
	}

}
