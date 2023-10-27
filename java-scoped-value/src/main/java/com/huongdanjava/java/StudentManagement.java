package com.huongdanjava.java;

public class StudentManagement {

  public String getLoggedUserInfo() {
    UserService us = new UserService();
    if (us.validateUser()) {
      return "Valid user";
    }

    return "Invalid user";
  }
}
