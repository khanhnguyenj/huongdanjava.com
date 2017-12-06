package com.huongdanjava.jpamanymanyextracolumns;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexample");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Project project  = em.find(Project.class, 1);

        System.out.println("Project: " + project.getName());
        project.getDevelopers().forEach(
                (developer) -> System.out.println("Developer: "+ developer.getDeveloper().getName() + " | Task: " + developer.getTask())
        );

        em.close();
        emf.close();
    }
}
