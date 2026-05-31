package com.huongdanjava.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/hello")
  public String index() {
    logger.info("Hello World");

    return "Hello from Huong Dan Java";
  }
}