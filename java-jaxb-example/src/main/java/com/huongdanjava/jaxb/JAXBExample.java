package com.huongdanjava.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBExample {

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
