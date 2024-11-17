package com.huongdanjava.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Application {

  public static void main(String[] args) throws IOException {
    String json = "{\"name\":\"Khanh\",\"age\":30}";

    ObjectMapper om = new ObjectMapper();
    Student obj = om.readValue(json, Student.class);
    System.out.println(obj);
  }
}
