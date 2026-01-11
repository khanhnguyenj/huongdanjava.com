package com.huongdanjava.springboot.springai;

import java.util.HashMap;
import java.util.Map;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class HuongDanJava {

  private Map<String, Integer> users = new HashMap<>();

  @Tool(name = "addUser", description = "Add a user with an age to the list. Need to specify user name and age of user")
  public String addUser(String name, int age) {
    users.put(name, age);

    return "Welcome, " + name;
  }

  @Tool(name = "getAge", description = "Base on the name in the input, return age of user")
  public String getAge(String name) {
    try {
      int age = users.get(name);

      return String.format("%s is %s years old", name, age);
    } catch (Exception e) {
      return "No user found!";
    }
  }
}
