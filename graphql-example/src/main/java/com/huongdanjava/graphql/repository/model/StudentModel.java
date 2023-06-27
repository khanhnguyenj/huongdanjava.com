package com.huongdanjava.graphql.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class StudentModel {

  @Column
  @Id
  private Long id;

  @Column
  private String code;

  @Column
  private String name;

  @Column
  private Long age;

  @Column
  private String address;

  @Column(name = "class")
  private String clazz;

}
