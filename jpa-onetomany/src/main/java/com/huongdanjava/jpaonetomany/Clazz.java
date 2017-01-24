package com.huongdanjava.jpaonetomany;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Clazz {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@OneToMany(mappedBy = "clazz")
	private Collection<Student> students;

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

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

}
