package com.huongdanjava.springboot.micrometer;

import io.micrometer.observation.annotation.Observed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Observed(name = "helloController")
@RestController
public class HelloController {

  @GetMapping("/hello")
  public String sayHello() {
    return "Hello from Huong Dan Java";
  }
}
