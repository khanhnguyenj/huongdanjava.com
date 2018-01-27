package com.huongdanjava.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Student, Long> {

}
