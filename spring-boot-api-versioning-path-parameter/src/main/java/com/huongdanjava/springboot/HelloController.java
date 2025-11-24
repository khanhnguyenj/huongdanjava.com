package com.huongdanjava.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v{version}")
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return """
        {
          "message": "Hello from Huong Dan Java!"
        }
        """;
  }

  @GetMapping(value = "/hello", version = "1.1.0")
  public String hello1_1() {
    return """
        {
          "message": "Hello from Huong Dan Java! V1.1.0"
        }
        """;
  }

}
