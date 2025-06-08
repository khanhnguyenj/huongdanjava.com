package com.huongdanjava.graphql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.huongdanjava.graphql.util.DataFetchersDelegateQuery;
import graphql.schema.DataFetchingEnvironment;

@Service
public class DataFetchersDelegateQueryImpl implements DataFetchersDelegateQuery {

  @Override
  public List<Student> students(DataFetchingEnvironment dataFetchingEnvironment, String clazz) {
    if (clazz == null) {
      return StudentRepository.findAll();
    }

    return StudentRepository.findByClazz(clazz);
  }

  static class StudentRepository {
    // @formatter:off
    static List<Student> students = Arrays.asList(
        Student.builder()
            .withId(UUID.randomUUID())
            .withCode("001")
            .withName("Khanh")
            .withAge(35)
            .withAddress("Binh Dinh")
            .withClazz("A")
            .build(),
        Student.builder()
            .withId(UUID.randomUUID())
            .withCode("002")
            .withName("Quan")
            .withAge(25)
            .withAddress("Ho Chi Minh")
            .withClazz("B")
            .build());
    // @formatter:on

    public static List<Student> findAll() {
      return students;
    }

    public static List<Student> findByClazz(String clazz) {
      List<Student> studentsByClazz = new ArrayList<>();
      for (Student student : students) {
        if (student.getClazz().equals(clazz)) {
          studentsByClazz.add(student);
        }
      }
      return studentsByClazz;
    }
  }

}