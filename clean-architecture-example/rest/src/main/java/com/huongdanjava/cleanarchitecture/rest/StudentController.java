package com.huongdanjava.cleanarchitecture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.huongdanjava.cleanarchitecture.entities.Student;
import com.huongdanjava.cleanarchitecture.rest.dto.StudentDto;
import com.huongdanjava.cleanarchitecture.rest.mapper.StudentMapper;
import com.huongdanjava.cleanarchitecture.usecases.student.FindStudentByNameUseCase;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private FindStudentByNameUseCase findStudentByNameUseCase;

  @GetMapping("/find")
  public ResponseEntity<StudentDto> findByName(@RequestParam String name) {
    Student student = findStudentByNameUseCase.find(name);

    return new ResponseEntity<>(StudentMapper.toDto(student), HttpStatus.OK);
  }

}
