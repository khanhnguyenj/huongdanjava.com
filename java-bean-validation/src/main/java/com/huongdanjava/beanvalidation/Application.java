package com.huongdanjava.beanvalidation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Application {

	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Student student = new Student();
		student.setName("Khanh");
		student.setAge(12);
		
		Set<ConstraintViolation<Student>> violations = validator.validate(student);
		for (ConstraintViolation<Student> violation : violations) {
		    System.err.println(violation.getMessage());
		}
	}
}
