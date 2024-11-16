package com.huongdanjava.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbExample {

  public static void main(String[] args) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

      File file = new File("student.xml");
      Student student = (Student) jaxbUnmarshaller.unmarshal(file);
      System.out.println(student);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}
