package com.huongdanjava.beanvalidation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

public class Student {
	
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@Min(value = 18, message = "Age should not be less than 18")
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
