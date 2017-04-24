package com.huongdanjava.springoverloadedconstructorinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		BeanFactory context = new ClassPathXmlApplicationContext("spring.xml");

		Student student = (Student) context.getBean("student");
		System.out.println(student.toString());
	}
}
