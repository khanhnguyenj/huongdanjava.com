package com.huongdanjava.springmvcrequestmapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//	@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
//	public String hello() {
//		return "Hello World!";
//	}

	@RequestMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String hello() {
		return "Hello World!";
	}
}
