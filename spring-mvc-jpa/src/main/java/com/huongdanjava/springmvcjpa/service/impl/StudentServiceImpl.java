package com.huongdanjava.springmvcjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huongdanjava.springmvcjpa.dao.StudentDao;
import com.huongdanjava.springmvcjpa.entity.Student;
import com.huongdanjava.springmvcjpa.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public com.huongdanjava.springmvcjpa.web.entity.Student findById(Long id) {
		Student studentFromDb = studentDao.findById(id);

		if (studentFromDb == null) {
			return null;
		}

		com.huongdanjava.springmvcjpa.web.entity.Student student = new com.huongdanjava.springmvcjpa.web.entity.Student();
		student.setName(studentFromDb.getName());

		return student;
	}

}
