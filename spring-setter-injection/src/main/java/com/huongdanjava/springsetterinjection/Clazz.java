package com.huongdanjava.springsetterinjection;

public class Clazz {

    private String name;
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Clazz [name=" + name + ", student=" + student + "]";
    }
}
