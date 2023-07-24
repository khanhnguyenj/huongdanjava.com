package com.huongdanjava.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class GraphQLController {

  @Autowired
  private StudentRepository studentRepository;

  @SchemaMapping(typeName = "Query", field = "students")
  public Flux<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @QueryMapping
  public Mono<Student> studentById(@Argument("id") Long id) {
    return studentRepository.findById(id);
  }
}
