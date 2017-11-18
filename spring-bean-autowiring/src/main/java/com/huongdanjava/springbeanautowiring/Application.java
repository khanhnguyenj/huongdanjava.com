package com.huongdanjava.springbeanautowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Application {

    public static void main(String[] args) {
    		// Call Spring container
        BeanFactory context = new XmlBeanFactory(new ClassPathResource("spring.xml"));

        Table table = (Table) context.getBean("table");

        // Request object with id "room"
//        Room room = (Room) context.getBean("room");
//        if (room.getTable() != null) {
//            System.out.println(room.getTable().toString());
//        }

    }

}