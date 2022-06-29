package com.huongdanjava.graphql.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.huongdanjava.graphql.repository.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {

  List<StudentModel> findByClazz(String clazz);

  List<NamesOnly> findBy();

  interface NamesOnly {
    String getName();
  }
}
