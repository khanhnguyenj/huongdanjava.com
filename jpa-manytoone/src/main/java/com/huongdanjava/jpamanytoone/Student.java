package com.huongdanjava.jpamanytoone;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}

