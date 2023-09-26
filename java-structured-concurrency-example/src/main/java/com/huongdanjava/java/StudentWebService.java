package com.huongdanjava.java;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class StudentWebService implements Callable<List<Student>> {

  @Override
  public List<Student> call() throws Exception {
    Thread.sleep(10000);
    return Arrays.asList(new Student("Thanh"), new Student("Binh"));
  }
}
