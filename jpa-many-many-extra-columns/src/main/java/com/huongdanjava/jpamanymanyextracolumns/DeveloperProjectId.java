package com.huongdanjava.jpamanymanyextracolumns;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperProjectId implements Serializable {

  @Column(name = "developer_id")
  private Integer developerId;

  @Column(name = "project_id")
  private Integer projectId;

}
