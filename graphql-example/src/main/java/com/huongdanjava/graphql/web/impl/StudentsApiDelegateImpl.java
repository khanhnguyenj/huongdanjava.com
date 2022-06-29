package com.huongdanjava.graphql.web.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.huongdanjava.graphql.dto.Student;
import com.huongdanjava.graphql.repository.StudentRepository;
import com.huongdanjava.graphql.repository.StudentRepository.NamesOnly;
import com.huongdanjava.graphql.repository.model.StudentModel;
import com.huongdanjava.graphql.web.StudentsApiDelegate;

@Service
public class StudentsApiDelegateImpl implements StudentsApiDelegate {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public ResponseEntity<List<Student>> getStudents(String clazz) {
    List<Student> students = new ArrayList<>();
    List<StudentModel> studentModels = findStudentModels(clazz);

    for (StudentModel sm : studentModels) {
      Student student = toStudent(sm);
      students.add(student);
    }

    return ResponseEntity.ok(students);
  }

  private Student toStudent(StudentModel sm) {
    Student student = new Student();
    BeanUtils.copyProperties(sm, student);

    return student;
  }

  private List<StudentModel> findStudentModels(String clazz) {
    if (clazz == null) {
      return studentRepository.findAll();
    }

    return studentRepository.findByClazz(clazz);
  }

  @Override
  public ResponseEntity<List<String>> getStudentNames() {
    List<String> studentNames = new ArrayList<>();

    List<NamesOnly> studentNamesOnly = studentRepository.findBy();
    studentNamesOnly.forEach(n -> studentNames.add(n.getName()));

    return ResponseEntity.ok(studentNames);
  }

}
