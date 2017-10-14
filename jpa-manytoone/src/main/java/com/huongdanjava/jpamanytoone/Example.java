package com.huongdanjava.jpamanytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Example {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexample");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Clazz clazz = new Clazz();
        clazz.setName("Class A");
        em.persist(clazz);

        Student student1 = new Student();
        student1.setName("Khanh");
        student1.setClazz(clazz);
        em.persist(student1);

        Student student2 = new Student();
        student2.setName("Phung");
        student2.setClazz(clazz);
        em.persist(student2);

        transaction.commit();

        em.close();
        emf.close();
    }

}

