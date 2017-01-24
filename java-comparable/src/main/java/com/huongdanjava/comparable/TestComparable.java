package com.huongdanjava.comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class TestComparable {

    public static void main(String args[]) {
        TreeSet<Student> students = new TreeSet<Student>();

        students.add(new Student(21, "Khanh"));
        students.add(new Student(26, "Tan"));
        students.add(new Student(24, "Phuong"));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getCode());
        }
    }
}
