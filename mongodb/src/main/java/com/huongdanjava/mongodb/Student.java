package com.huongdanjava.mongodb;

import org.bson.Document;

public class Student extends Document {

    private static final String NAME = "name";
    private static final String AGE = "age";
    public static final String COLLECTION_NAME = "student";

    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public Integer getAge() {
        return getInteger(AGE);
    }

    public void setAge(Integer age) {
        put(AGE, age);
    }
}
