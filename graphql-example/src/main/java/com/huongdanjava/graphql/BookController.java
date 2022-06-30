package com.huongdanjava.graphql;

import java.util.List;
import org.springframework.stereotype.Controller;
import com.huongdanjava.graphql.repository.StudentRepository;
import com.huongdanjava.graphql.repository.model.StudentModel;

@Controller
public class BookController {

  private final StudentRepository studentRepository;

  public BookController(StudentRepository bookRepository) {
    this.studentRepository = bookRepository;
  }

  public List<StudentModel> findAll() {
    return studentRepository.findAll();
  }
}
