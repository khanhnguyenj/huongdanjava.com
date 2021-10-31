package com.huongdanjava.jpamanymanyextracolumns;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

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
