package com.huongdanjava.jpamanytomany;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "projects")
    private Collection<Developer> developers;

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

    public Collection<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Collection<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!id.equals(project.id)) return false;
        return name.equals(project.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
