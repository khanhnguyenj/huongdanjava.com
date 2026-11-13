package com.huongdanjava.springdatajpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "students")
@Entity
@Getter
@Setter
public class Student {

  @Id @GeneratedValue private Long id;

  @Column private String name;
}
