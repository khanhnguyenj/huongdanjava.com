package com.huongdanjava.dapr.serviceinvocation2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "Hello from Huong Dan Java!";
  }

}
