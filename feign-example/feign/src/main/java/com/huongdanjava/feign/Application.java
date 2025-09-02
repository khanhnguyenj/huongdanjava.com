package com.huongdanjava.feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

public class Application {

  public static void main(String[] args) {
    Service service = Feign.builder().encoder(new GsonEncoder())
        .target(Service.class, "http://localhost:8080");

    System.out.println(service.getStudent("123"));

    Map<String, String> queryMap = new HashMap<>();
    queryMap.put("name", "Khanh");
    System.out.println(service.searchStudent(queryMap));

    AddNewStudentRequest addNewStudentRequest = new AddNewStudentRequest("Khanh");
    Map<String, String> headerMap = new HashMap<>();
    headerMap.put("Content-Type", "application/json");
    System.out.println(service.addNewStudent(headerMap, addNewStudentRequest));
  }
}
