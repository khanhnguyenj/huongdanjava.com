
package com.huongdanjava.ramlspringmvc.web.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Student implements Serializable
{

    final static long serialVersionUID = 9154676657759846777L;
    protected Long id;
    protected String code;
    protected String name;

    /**
     * Creates a new Student.
     * 
     */
    public Student() {
        super();
    }

    /**
     * Creates a new Student.
     * 
     */
    public Student(Long id, String code, String name) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
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
     * Returns the code.
     * 
     * @return
     *     code
     */
    @NotNull
    public String getCode() {
        return code;
    }

    /**
     * Set the code.
     * 
     * @param code
     *     the new code
     */
    public void setCode(String code) {
        this.code = code;
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

    public int hashCode() {
        return new HashCodeBuilder().append(id).append(code).append(name).toHashCode();
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
        Student otherObject = ((Student) other);
        return new EqualsBuilder().append(id, otherObject.id).append(code, otherObject.code).append(name, otherObject.name).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("code", code).append("name", name).toString();
    }

}
