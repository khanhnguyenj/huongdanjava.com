package com.huongdanjava.springboot.mysql.repository;

import com.huongdanjava.springboot.mysql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}