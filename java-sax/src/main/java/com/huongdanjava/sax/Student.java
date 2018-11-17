package com.huongdanjava.sax;

public class Student {

	private String name;
	private String age;
	private String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", code=" + code + "]";
	}
}
