package com.huongdanjava.jpa;

import javax.persistence.*;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexample");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT c FROM Clazz c");
		List<Clazz> resultList = query.getResultList();

		resultList.stream().forEach(c -> System.out.println(c.getName()));
	}
}