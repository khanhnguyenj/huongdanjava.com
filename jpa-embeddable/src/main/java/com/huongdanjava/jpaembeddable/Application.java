package com.huongdanjava.jpaembeddable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexample");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Student student  = em.find(Student.class, new StudentId(1, 123));

        System.out.println("Student name: " + student.getName());

        em.close();
        emf.close();
    }
}
