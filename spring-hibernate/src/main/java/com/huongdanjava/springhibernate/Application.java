package com.huongdanjava.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
        Session session = sf.openSession();

        Query<Student> q = session.createQuery("From Student ");

        List<Student> resultList = q.list();
        for (Student next : resultList) {
            System.out.println("Student name: " + next.getName());
        }
    }
}