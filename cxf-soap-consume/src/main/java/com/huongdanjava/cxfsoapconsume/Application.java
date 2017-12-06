package com.huongdanjava.cxfsoapconsume;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huongdanjava.muleesbcxfsoapexpose.HelloWorldService;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		HelloWorldService hello = (HelloWorldService) ac.getBean("hello");

		System.out.println(hello.hello("Khanh"));
	}
}
