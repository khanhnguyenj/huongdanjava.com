package com.huongdanjava.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsulServiceRegisterServiceExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsulServiceRegisterServiceExampleApplication.class, args);
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello from Huong Dan Java";
  }

}
