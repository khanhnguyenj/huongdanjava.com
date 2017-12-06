package com.huongdanjava.jpamanymanyextracolumns;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "developer_project")
@Data
public class DeveloperProject {

    @EmbeddedId
    private DeveloperProjectId developerProjectId;

    @ManyToOne
    @MapsId("developerId")
    private Developer developer;

    @ManyToOne
    @MapsId("projectId")
    private Project project;

    @Column
    private String task;
}
