package com.huongdanjava.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @formatter:off
@ComponentScan(
    basePackages = {
        "org.openapitools",
        "com.huongdanjava.graphql",
        "org.openapitools.configuration"
    }
)
// @formatter:on
public class GraphqlExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphqlExampleApplication.class, args);
  }

}
