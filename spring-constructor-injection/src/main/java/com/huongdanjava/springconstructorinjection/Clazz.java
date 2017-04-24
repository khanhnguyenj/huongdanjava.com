package com.huongdanjava.springconstructorinjection;

public class Clazz {

	private String name;
	private Student student;

	public Clazz(String name, Student student) {
		this.name = name;
		this.student = student;
	}

	@Override
	public String toString() {
		return "Clazz [name=" + name + ", student=" + student + "]";
	}

}
