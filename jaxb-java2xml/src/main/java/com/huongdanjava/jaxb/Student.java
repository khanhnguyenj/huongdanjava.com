package com.huongdanjava.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

  private String name;
  private String age;
  private String code;

  public String getName() {
    return name;
  }

  @XmlElement
  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  @XmlElement
  public void setAge(String age) {
    this.age = age;
  }

  public String getCode() {
    return code;
  }

  @XmlElement
  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", age=" + age + ", code=" + code + "]";
  }
}
