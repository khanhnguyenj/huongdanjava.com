package com.huongdanjava.cleanarchitecture.rest.mapper;

import com.huongdanjava.cleanarchitecture.entities.Student;
import com.huongdanjava.cleanarchitecture.rest.dto.StudentDto;

public class StudentMapper {

  public static StudentDto toDto(Student entity) {
    if (entity == null) {
      return null;
    }

    StudentDto studentDto = new StudentDto(entity.name(), entity.age());

    return studentDto;
  }
}
