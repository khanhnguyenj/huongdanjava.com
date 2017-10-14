package com.huongdanjava.jpamanytomany;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Developer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "developer_project",
        joinColumns = @JoinColumn(name = "developer_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Collection<Project> projects;

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

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (!id.equals(developer.id)) return false;
        return name.equals(developer.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
