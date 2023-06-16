package com.huongdanjava.cleanarchitecture.db.mapper;

import com.huongdanjava.cleanarchitecture.db.model.StudentModel;
import com.huongdanjava.cleanarchitecture.entities.Student;

public class StudentMapper {

  public static Student toEntity(StudentModel model) {
    if (model == null) {
      return null;
    }

    Student student = new Student();
    student.setName(model.getName());
    student.setAge(model.getAge());

    return student;
  }
}
