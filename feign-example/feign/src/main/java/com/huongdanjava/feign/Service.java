package com.huongdanjava.feign;

import feign.HeaderMap;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import java.util.Map;

public interface Service {

  @RequestLine("GET /students/{id}")
  String getStudent(@Param("id") String id);

  @RequestLine("GET /students")
  String searchStudent(@QueryMap Map<String, String> queryParams);

  @RequestLine("POST /students")
  String addNewStudent(@HeaderMap Map<String, String> headerMap,
      AddNewStudentRequest addNewStudentRequest);
}
