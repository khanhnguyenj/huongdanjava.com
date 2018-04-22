package com.huongdanjava.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

public class Application {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();

        MongoDatabase mongodb = client.getDatabase("mongodb");

        MongoCollection<Document> studentCollection = mongodb.getCollection(Student.COLLECTION_NAME);

        Student student = new Student();
        student.setName("Khanh");

        DeleteResult deleteResult = studentCollection.deleteOne(student);
        System.out.println(deleteResult.getDeletedCount());
    }
}