package com.huongdanjava.cleanarchitecture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.huongdanjava.cleanarchitecture.db.StudentAdapterImpl;
import com.huongdanjava.cleanarchitecture.usecases.adapter.StudentAdapter;
import com.huongdanjava.cleanarchitecture.usecases.student.FindStudentByNameUseCase;

@Configuration
public class UseCaseConfiguration {

  @Bean
  FindStudentByNameUseCase findStudentByNameUseCase(StudentAdapter studentAdapter) {
    return new FindStudentByNameUseCase(studentAdapter);
  }

  @Bean
  StudentAdapter studentAdapter() {
    return new StudentAdapterImpl();
  }
}
