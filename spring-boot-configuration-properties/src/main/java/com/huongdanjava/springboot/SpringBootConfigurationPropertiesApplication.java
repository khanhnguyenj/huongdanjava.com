package com.huongdanjava.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConfigurationPropertiesApplication implements CommandLineRunner {
	
	@Autowired
	private Student student;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationPropertiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(student.getClazz() + "-" + student.getName() + "-" + student.getScores());
		System.out.println(student.getAddress().getStreet());
	}
}
