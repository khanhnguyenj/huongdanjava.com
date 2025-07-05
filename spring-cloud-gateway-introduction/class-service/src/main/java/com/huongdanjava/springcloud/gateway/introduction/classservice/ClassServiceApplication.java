package com.huongdanjava.springcloud.gateway.introduction.classservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClassServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClassServiceApplication.class, args);
  }

  @GetMapping("/classes/hello")
  public String hello() {
    return "Hello from Class Service";
  }
}
