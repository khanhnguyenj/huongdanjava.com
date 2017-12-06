package com.huongdanjava.springaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Clazz clazzA = (Clazz) context.getBean("clazzA");

		Clazz clazzB = (Clazz) clazzA.getContext().getBean("clazzB");

		System.out.println("\n" + clazzB.getName());
	}

}