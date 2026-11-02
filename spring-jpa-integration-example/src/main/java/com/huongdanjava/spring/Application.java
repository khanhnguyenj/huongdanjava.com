package com.huongdanjava.spring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    EntityManagerFactory emf = (EntityManagerFactory) ac.getBean("entityManagerFactory");
    EntityManager em = emf.createEntityManager();

    Student student = em.find(Student.class, 1);

    System.out.println(student.getName());
  }
}
