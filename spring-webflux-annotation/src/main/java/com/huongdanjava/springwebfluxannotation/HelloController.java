package com.huongdanjava.springwebfluxannotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public Flux<String> findAll() {
		return Flux.just("Hello, Huong Dan Java");
	}
}
