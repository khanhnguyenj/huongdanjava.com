package com.huongdanjava.java;

public class Application {

  public static final ScopedValue<String> LOGGED_USER = ScopedValue.newInstance();

  public static void main(String[] args) {
    String user = "Khanh";

    StudentManagement sm = new StudentManagement();
    UserService us = new UserService();

    ScopedValue.where(LOGGED_USER, user).run(()-> {
          sm.getLoggedUserInfo();
          us.doSomeThing();
        }
    );
    us.doSomeThing();
  }
}
