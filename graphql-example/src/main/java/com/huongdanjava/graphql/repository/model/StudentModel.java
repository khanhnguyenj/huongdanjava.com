package com.huongdanjava.graphql.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class StudentModel {

  @Column
  private Long id;

  @Column
  private String code;

  @Column
  private String name;

  @Column
  private Integer age;

  @Column
  private String address;

  @Column
  private String clazz;

}
