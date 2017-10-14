package com.huongdanjava.springjpa.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        EntityManagerFactory emf = (EntityManagerFactory) ac.getBean("entityManagerFactory");
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, Long.valueOf(1));
        System.out.println(student.getName());
    }
}
