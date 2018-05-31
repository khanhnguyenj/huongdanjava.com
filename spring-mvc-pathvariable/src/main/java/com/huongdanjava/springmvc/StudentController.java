package com.huongdanjava.springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping(value = "/student/{id}")
	String findById(@PathVariable(value = "id", required = false) String studentId) {
		return "Student ID: " + studentId;
	}
}
