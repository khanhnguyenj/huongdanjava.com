package com.huongdanjava.springhelloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		// Gọi khung chứa của Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		// Yêu cầu lấy đối tượng SayHello
		SayHello sayHello = (SayHello) context.getBean("hello");

		// Sau khi lấy xong thì bạn có thể làm những gì bạn muốn
		sayHello.say();
	}
}
