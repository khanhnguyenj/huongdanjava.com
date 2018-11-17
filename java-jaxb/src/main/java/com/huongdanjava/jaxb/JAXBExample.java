package com.huongdanjava.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {

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
