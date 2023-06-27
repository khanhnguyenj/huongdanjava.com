package com.huongdanjava.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {

  @QueryMapping
  public String hello(@Argument("name") String name) {
    return "Hello, " + name;
  }
}
