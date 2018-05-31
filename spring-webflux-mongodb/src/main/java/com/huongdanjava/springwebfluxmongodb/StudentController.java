package com.huongdanjava.springwebfluxmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping(value = "/students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> findAllStudents() {
		return studentRepository.findBy();
	}

	@PostMapping("/student")
	public Mono<Student> createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
}
