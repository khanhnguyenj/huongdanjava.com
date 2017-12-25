package com.huongdanjava.jpageneratedvalue;

import org.hibernate.id.MultipleHiLoPerTableGenerator;
import org.hibernate.id.enhanced.TableGenerator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexample");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        for (int i = 0 ; i < 5; i++) {
            Clazz clazz = new Clazz();
            clazz.setName("Class B");
            em.persist(clazz);
        }

        transaction.commit();
    }
}
