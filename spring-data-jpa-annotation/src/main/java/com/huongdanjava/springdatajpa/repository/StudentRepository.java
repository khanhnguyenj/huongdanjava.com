package com.huongdanjava.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huongdanjava.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
