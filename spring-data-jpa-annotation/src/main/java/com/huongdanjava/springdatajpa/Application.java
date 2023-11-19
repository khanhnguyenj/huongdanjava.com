package com.huongdanjava.springdatajpa;

import java.util.Optional;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.huongdanjava.springdatajpa.entity.Student;
import com.huongdanjava.springdatajpa.repository.StudentRepository;

public class Application {

  public static void main(String[] args) {
    ApplicationContext ac = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);

    StudentRepository helloRepository = (StudentRepository) ac.getBean("studentRepository");
    Optional<Student> student = helloRepository.findById(1L);

    System.out.println(student.get().getName());
  }

}
