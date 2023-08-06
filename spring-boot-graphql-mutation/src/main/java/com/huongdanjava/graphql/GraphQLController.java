package com.huongdanjava.graphql;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class GraphQLController {

  @Autowired
  private StudentRepository studentRepository;

  @QueryMapping
  public Flux<Student> students() {
    return studentRepository.findAll();
  }

  @MutationMapping
  public Mono<Student> addStudent(@Argument("student") Student student) {
    return studentRepository.save(student);
  }

  @MutationMapping
  public Mono<Student> updateStudent(@Argument("studentId") String id,
      @Argument("student") Student student) {
    student.setId(UUID.fromString(id));
    return studentRepository.save(student);
  }

  @MutationMapping
  public Mono<String> deleteStudent(@Argument("studentId") String id) {
    return studentRepository.deleteById(UUID.fromString(id))
        .then(Mono.just("Deleted!"));
  }
}
