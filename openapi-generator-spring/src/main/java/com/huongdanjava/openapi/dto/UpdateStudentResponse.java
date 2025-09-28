package com.huongdanjava.openapi.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.huongdanjava.openapi.dto.Student;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateStudentResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-28T20:23:53.641444+08:00[Asia/Singapore]", comments = "Generator version: 7.15.0")
public class UpdateStudentResponse {

  private @Nullable Student data;

  private Boolean success;

  private @Nullable String message;

  public UpdateStudentResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateStudentResponse(Boolean success) {
    this.success = success;
  }

  public UpdateStudentResponse data(@Nullable Student data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public @Nullable Student getData() {
    return data;
  }

  public void setData(@Nullable Student data) {
    this.data = data;
  }

  public UpdateStudentResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Get success
   * @return success
   */
  @NotNull 
  @Schema(name = "success", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public UpdateStudentResponse message(@Nullable String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public @Nullable String getMessage() {
    return message;
  }

  public void setMessage(@Nullable String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateStudentResponse updateStudentResponse = (UpdateStudentResponse) o;
    return Objects.equals(this.data, updateStudentResponse.data) &&
        Objects.equals(this.success, updateStudentResponse.success) &&
        Objects.equals(this.message, updateStudentResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, success, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateStudentResponse {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

