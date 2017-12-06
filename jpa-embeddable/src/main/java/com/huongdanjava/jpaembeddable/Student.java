package com.huongdanjava.jpaembeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
public class Student {

    @EmbeddedId
    private StudentId id;

    @Column
    private String name;
}
