package com.huongdanjava.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByClazzOrderByNameDesc(String clazz);
}
