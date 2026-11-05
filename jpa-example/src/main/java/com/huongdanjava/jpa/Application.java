package com.huongdanjava.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

  static void main(String[] args) {
    try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU")) {
      EntityManager em = emf.createEntityManager();

      Student student = em.find(Student.class, 1);

      System.out.println(student.getName());
    }
  }
}
