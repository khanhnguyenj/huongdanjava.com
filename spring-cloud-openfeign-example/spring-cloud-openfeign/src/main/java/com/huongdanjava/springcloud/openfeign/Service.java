package com.huongdanjava.springcloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service", url = "http://localhost:8080")
public interface Service {

  @GetMapping("/students/{id}")
  String getStudent(@PathVariable String id);

  @GetMapping("/students")
  String searchStudent(@RequestParam String name);

  @PostMapping("/students")
  String addNewStudent(@RequestBody AddNewStudentRequest addNewStudentRequest);
}