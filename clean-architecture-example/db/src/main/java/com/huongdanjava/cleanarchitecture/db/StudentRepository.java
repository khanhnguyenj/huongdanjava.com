package com.huongdanjava.cleanarchitecture.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huongdanjava.cleanarchitecture.db.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    StudentModel findByName(String name);
}
