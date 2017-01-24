package com.huongdanjava.jpaonetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Example {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		Clazz clazz = em.find(Clazz.class, 1);

		System.out.println("Number of students: " + clazz.getStudents().size());

		em.close();
		emf.close();
	}

}