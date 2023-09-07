package com.huongdanjava.springwebfluxannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;

  @RequestMapping(value = "/students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Student> findAll() {
    return studentService.all();
  }
}
