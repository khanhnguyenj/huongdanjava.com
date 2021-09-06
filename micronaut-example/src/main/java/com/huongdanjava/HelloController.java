package com.huongdanjava;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloController {

  @Get("/")
  public String hello() {
    return "Hello World from Huong Dan Java";
  }
}
