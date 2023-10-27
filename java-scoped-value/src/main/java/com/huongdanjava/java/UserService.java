package com.huongdanjava.java;

public class UserService {

  public boolean validateUser() {
    String loggedUser = Application.LOGGED_USER.get();
    System.out.println("Logged user: " + loggedUser);
    return true;
  }

  public void doSomeThing() {
    String loggedUser = Application.LOGGED_USER.get();
    System.out.println("Logged user1: " + loggedUser);
  }
}
