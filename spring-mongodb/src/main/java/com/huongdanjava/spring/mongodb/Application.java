package com.huongdanjava.spring.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class Application {

    public static void main(String[] args) {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        MongoOperations mo = (MongoOperations) ac.getBean("mongoTemplate");

        MongoCollection<Document> studentCollection = mo.getCollection(Student.COLLECTION_NAME);

        Student student = new Student();
        student.setName("Khanh");
        student.setAge(31);

        studentCollection.insertOne(student);
    }
}
