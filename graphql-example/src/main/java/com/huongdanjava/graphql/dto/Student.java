package com.huongdanjava.graphql.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Student
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-29T06:46:29.853641+07:00[Asia/Ho_Chi_Minh]")
public class Student {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("code")
  private String code;

  @JsonProperty("name")
  private String name;

  @JsonProperty("age")
  private Long age;

  @JsonProperty("address")
  private String address;

  @JsonProperty("clazz")
  private String clazz;

  public Student id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Student code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  
  @Schema(name = "code", required = false)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Student name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Student age(Long age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  */
  
  @Schema(name = "age", required = false)
  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public Student address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  
  @Schema(name = "address", required = false)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Student clazz(String clazz) {
    this.clazz = clazz;
    return this;
  }

  /**
   * Get clazz
   * @return clazz
  */
  
  @Schema(name = "clazz", required = false)
  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) &&
        Objects.equals(this.code, student.code) &&
        Objects.equals(this.name, student.name) &&
        Objects.equals(this.age, student.age) &&
        Objects.equals(this.address, student.address) &&
        Objects.equals(this.clazz, student.clazz);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, name, age, address, clazz);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    clazz: ").append(toIndentedString(clazz)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

