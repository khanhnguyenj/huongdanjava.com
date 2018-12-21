package com.huongdanjava.springqualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Room room = (Room) context.getBean("room");
		if (room.getTable() != null) {
			System.out.println(room.getTable().toString());
		}

	}

}