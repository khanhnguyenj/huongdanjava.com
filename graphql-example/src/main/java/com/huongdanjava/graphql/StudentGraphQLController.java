package com.huongdanjava.graphql;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.huongdanjava.graphql.repository.StudentRepository;
import com.huongdanjava.graphql.repository.model.StudentModel;

@Controller
public class StudentGraphQLController {

  @Autowired
  private StudentRepository studentRepository;

  @QueryMapping
  public List<StudentModel> students(@Argument("clazz") String clazz) {
    if (clazz == null) {
      return studentRepository.findAll();
    }

    return studentRepository.findByClazz(clazz);
  }
}
