package com.huongdanjava.java;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class StudentDatabaseService implements Callable<List<Student>> {

  @Override
  public List<Student> call() throws Exception {
    //return Arrays.asList(new Student("Khanh"), new Student("Quan"));
    throw new Exception("Something went wrong");
  }
}
