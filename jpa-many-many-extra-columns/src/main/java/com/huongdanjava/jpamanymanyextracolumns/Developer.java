package com.huongdanjava.jpamanymanyextracolumns;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table
@Entity
@Data
public class Developer implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "project")
    private List<DeveloperProject> projects;
}
