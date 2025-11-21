package com.huongdanjava.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return """
        {
          "message": "Hello from Huong Dan Java!"
        }
        """;
  }

  @GetMapping(value = "/hello", version = "1.1")
  public String hello1_1() {
    return """
        {
          "message": "Hello from Huong Dan Java! V1.1"
        }
        """;
  }

}
