package com.huongdanjava.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Application {

  public static void main(String[] args) throws JsonProcessingException {
    Student student = new Student();
    student.setName("Khanh");
    student.setAge(30);

    ObjectMapper om = new ObjectMapper();
    String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(student);
    System.out.println(json);
  }
}
