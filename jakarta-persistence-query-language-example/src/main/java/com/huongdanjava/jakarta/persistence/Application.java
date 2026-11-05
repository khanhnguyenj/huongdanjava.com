package com.huongdanjava.jakarta.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class Application {

  public static void main(String[] args) {
    try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU");
        EntityManager em = emf.createEntityManager(); ) {

      TypedQuery<Clazz> query =
          em.createQuery("SELECT c FROM Clazz c WHERE c.name = :name", Clazz.class);
      query.setParameter("name", "Class A");

      List<Clazz> resultList = query.getResultList();
      resultList.stream().forEach(c -> System.out.println(c.getName()));
    }
  }
}
