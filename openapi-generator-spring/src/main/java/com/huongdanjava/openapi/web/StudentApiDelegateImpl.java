package com.huongdanjava.openapi.web;

import com.huongdanjava.openapi.dto.GetStudentByIdResponse;
import com.huongdanjava.openapi.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
public class StudentApiDelegateImpl implements StudentsApiDelegate {

  @Override
  public Mono<ResponseEntity<GetStudentByIdResponse>> getStudentById(String id,
      ServerWebExchange exchange) {
    return StudentsApiDelegate.super.getStudentById(id, exchange);
  }

  //  @Override
//  public ResponseEntity<GetStudentByIdResponse> getStudentById(String id) {
//    GetStudentByIdResponse getStudentByIdResponse = new GetStudentByIdResponse();
//
//    getStudentByIdResponse.success(true);
//
//    Student student = new Student();
//    student.setId(1L);
//    student.setCode("123");
//    student.setName("HDJ");
//    getStudentByIdResponse.setData(student);
//
//    return ResponseEntity.ok(getStudentByIdResponse);
//  }
}
