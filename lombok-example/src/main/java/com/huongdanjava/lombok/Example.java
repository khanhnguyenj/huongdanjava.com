package com.huongdanjava.lombok;

import java.time.LocalDate;

public class Example {

  static void main(String[] args) {
    Student student = new Student("Khanh", "123", LocalDate.now());
    System.out.println(student.getName());
  }
}
