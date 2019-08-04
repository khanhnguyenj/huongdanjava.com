package com.huongdanjava.springmvcvalidation;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@PostMapping("/student")
	public String student(@Valid @RequestBody Student student) {
		return student.getName();
	}

}
