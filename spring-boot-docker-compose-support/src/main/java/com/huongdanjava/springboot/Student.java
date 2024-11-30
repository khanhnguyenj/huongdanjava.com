package com.huongdanjava.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

  private @Id long id;
  private String name;

  public Student() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
