package com.huongdanjava.springhelloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		// Call Spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		// Request to get SayHello object
		SayHello sayHello = (SayHello) context.getBean("hello");

		// Call any methods in SayHello object
		sayHello.say();
	}
}
