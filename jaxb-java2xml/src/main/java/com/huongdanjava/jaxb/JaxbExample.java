package com.huongdanjava.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class JaxbExample {

  public static void main(String[] args) {
    try {
      Student student = new Student();
      student.setName("Khanh");
      student.setCode("123456");
      student.setAge("30");

      JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      File file = new File("/Users/Khanh/Desktop/student.xml");
      jaxbMarshaller.marshal(student, file);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}
