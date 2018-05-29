package com.huongdanjava.springdatamongodb;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}