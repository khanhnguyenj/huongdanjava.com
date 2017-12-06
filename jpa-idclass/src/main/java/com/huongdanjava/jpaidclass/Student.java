package com.huongdanjava.jpaidclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@IdClass(StudentId.class)
public class Student {

    @Id
    private Integer id;

    @Id
    private Integer code;

    @Column
    private String name;
}
