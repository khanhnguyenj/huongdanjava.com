package com.huongdanjava.springmvcjpa.dao;

import com.huongdanjava.springmvcjpa.entity.Student;

public interface StudentDao {

	Student findById(Long id);
}
