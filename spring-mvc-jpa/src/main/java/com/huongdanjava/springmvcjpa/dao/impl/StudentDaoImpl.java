package com.huongdanjava.springmvcjpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.huongdanjava.springmvcjpa.dao.StudentDao;
import com.huongdanjava.springmvcjpa.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

}
