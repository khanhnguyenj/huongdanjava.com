package com.huongdanjava.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class Application {

  public static void main(String[] args) throws Exception {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      Subtask<List<Student>> studentsFromDatabaseSubtask = scope.fork(
          new StudentDatabaseService());

      Subtask<List<Student>> studentsFromWebServiceSubtask = scope.fork(
          new StudentWebService());

      scope.join();
      scope.throwIfFailed();

      List<Student> studentsFromDatabase = studentsFromDatabaseSubtask.get();
      List<Student> studentsFromWebService = studentsFromWebServiceSubtask.get();

      List<Student> students = new ArrayList<>();
      students.addAll(studentsFromDatabase);
      students.addAll(studentsFromWebService);

      students.forEach(s -> System.out.println(s.name()));
    }
  }
}
