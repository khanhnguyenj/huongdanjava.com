package com.huongdanjava.springdatajpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        HelloRepository helloRepository = (HelloRepository) ac.getBean("helloRepository");

        Student student = helloRepository.findById(new Long(2)).get();

        System.out.println(student.getName());
    }
}
