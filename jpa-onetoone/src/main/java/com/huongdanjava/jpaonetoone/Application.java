package com.huongdanjava.jpaonetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexample");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Tourist tourist = em.find(Tourist.class, 1);

        System.out.println("Tourist name: " + tourist.getName() + ", room: " + tourist.getRoom().getName());

        em.close();
        emf.close();
    }
}
