package com.huongdanjava.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jakarta.xmlbind.JakartaXmlBindAnnotationIntrospector;

public class Application {

  public static void main(String[] args) throws JsonProcessingException {
    Student student = new Student();
    student.setAge("37");
    student.setName("Khanh");
    student.setCode("123");

    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

    AnnotationIntrospector intr = new JakartaXmlBindAnnotationIntrospector(om.getTypeFactory());
    om.setAnnotationIntrospector(intr);

    String json = om.writeValueAsString(student);
    System.out.println(json);
  }

}
