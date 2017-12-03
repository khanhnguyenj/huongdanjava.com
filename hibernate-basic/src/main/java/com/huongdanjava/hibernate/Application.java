package com.huongdanjava.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Clazz clazz = new Clazz();
        clazz.setName("ABC");

        session.save(clazz);
        session.getTransaction().commit();

        Query<Clazz> q = session.createQuery("From Clazz ");

        List<Clazz> resultList = q.list();
        for (Clazz next : resultList) {
            System.out.println("Clazz name: " + next.getName());
        }
    }
}
