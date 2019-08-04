package com.huongdanjava.springmvcvalidation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Student {

	@NotNull
	private String name;
	
	@Min(value = 18)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
