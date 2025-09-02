package com.huongdanjava.feign.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

  @GetMapping("/students/{id}")
  public String getStudent(@PathVariable("id") String studentId) {
    return studentId;
  }

  @GetMapping("/students")
  public String searchStudent(@RequestParam String name) {
    return name;
  }

  @PostMapping("/students")
  public String addNewStudent(@RequestBody AddNewStudentRequest student) {
    return "Added new student: " + student.name();
  }

}
