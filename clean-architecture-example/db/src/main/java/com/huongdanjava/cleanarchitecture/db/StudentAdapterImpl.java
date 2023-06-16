package com.huongdanjava.cleanarchitecture.db;

import org.springframework.beans.factory.annotation.Autowired;
import com.huongdanjava.cleanarchitecture.db.mapper.StudentMapper;
import com.huongdanjava.cleanarchitecture.db.model.StudentModel;
import com.huongdanjava.cleanarchitecture.entities.Student;
import com.huongdanjava.cleanarchitecture.usecases.adapter.StudentAdapter;

public class StudentAdapterImpl implements StudentAdapter {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student findByName(String name) {
    StudentModel findByName = studentRepository.findByName(name);

    return StudentMapper.toEntity(findByName);
  }
}
