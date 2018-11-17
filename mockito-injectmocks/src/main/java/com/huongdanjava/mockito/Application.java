package com.huongdanjava.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Application {

	@Autowired
	private Calculation calculation;

	public boolean check(int a, int b) {
		int result = calculation.sub(a, b);

		return result > 0;
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		Application a = ac.getBean(Application.class);

		if (a.check(2, 4)) {
			System.out.println("Positive");
		} else {
			System.out.println("Negative");
		}
	}

}