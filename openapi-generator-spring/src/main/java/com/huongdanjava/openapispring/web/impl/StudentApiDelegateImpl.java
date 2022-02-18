package com.huongdanjava.openapispring.web.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.huongdanjava.openapispring.dto.Student;
import com.huongdanjava.openapispring.web.StudentsApiDelegate;

@Service
public class StudentApiDelegateImpl implements StudentsApiDelegate {

  @Override
  public ResponseEntity<Student> getStudentById(String ID) {
    Student student = new Student();
    student.setId(1L);
    student.setCode("123");
    student.setName("HDJ");

    return ResponseEntity.ok(student);
  }

}
