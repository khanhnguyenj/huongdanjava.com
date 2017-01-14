package com.huongdanjava.comparable;

public class Student implements Comparable<Student> {

    private int code;
    private String name;

    public Student(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Student o) {
        if (this.getCode() > o.getCode()) {
            return 1;
        }
        if (this.getCode() < o.getCode()) {
            return -1;
        }
        return 0;
    }
}
