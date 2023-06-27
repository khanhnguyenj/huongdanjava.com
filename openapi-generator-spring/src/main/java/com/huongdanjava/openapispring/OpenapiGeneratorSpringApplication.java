package com.huongdanjava.openapispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @formatter:off
@ComponentScan(
    basePackages = {
        "org.openapitools",
        "com.huongdanjava.openapispring",
        "org.openapitools.configuration"
    }
)
// @formatter:on
public class OpenapiGeneratorSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(OpenapiGeneratorSpringApplication.class, args);
  }

}
