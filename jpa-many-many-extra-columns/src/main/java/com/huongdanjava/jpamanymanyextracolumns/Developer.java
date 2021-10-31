package com.huongdanjava.jpamanymanyextracolumns;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Developer implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String name;

  @OneToMany(mappedBy = "developer")
  private List<DeveloperProject> projects;
}
