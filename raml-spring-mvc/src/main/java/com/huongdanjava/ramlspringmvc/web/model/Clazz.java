
package com.huongdanjava.ramlspringmvc.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Clazz implements Serializable
{

    final static long serialVersionUID = 9091882269756046136L;
    protected Long id;
    protected String name;
    protected List<com.huongdanjava.ramlspringmvc.web.model.Object> students = new ArrayList<com.huongdanjava.ramlspringmvc.web.model.Object>();

    /**
     * Creates a new Clazz.
     * 
     */
    public Clazz() {
        super();
    }

    /**
     * Creates a new Clazz.
     * 
     */
    public Clazz(Long id, String name, List<com.huongdanjava.ramlspringmvc.web.model.Object> students) {
        super();
        this.id = id;
        this.name = name;
        this.students = students;
    }

    /**
     * Returns the id.
     * 
     * @return
     *     id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id.
     * 
     * @param id
     *     the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name.
     * 
     * @return
     *     name
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * 
     * @param name
     *     the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the students.
     * 
     * @return
     *     students
     */
    @Valid
    public List<com.huongdanjava.ramlspringmvc.web.model.Object> getStudents() {
        return students;
    }

    /**
     * Set the students.
     * 
     * @param students
     *     the new students
     */
    public void setStudents(List<com.huongdanjava.ramlspringmvc.web.model.Object> students) {
        this.students = students;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(students).toHashCode();
    }

    public boolean equals(java.lang.Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (this.getClass()!= other.getClass()) {
            return false;
        }
        Clazz otherObject = ((Clazz) other);
        return new EqualsBuilder().append(id, otherObject.id).append(name, otherObject.name).append(students, otherObject.students).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("students", students).toString();
    }

}
