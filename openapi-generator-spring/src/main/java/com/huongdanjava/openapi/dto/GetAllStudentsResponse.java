package com.huongdanjava.openapi.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.huongdanjava.openapi.dto.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetAllStudentsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-28T20:23:53.641444+08:00[Asia/Singapore]", comments = "Generator version: 7.15.0")
public class GetAllStudentsResponse {

  private @Nullable Integer page;

  private @Nullable Integer size;

  private @Nullable Integer totalItems;

  private @Nullable Integer totalPages;

  @Valid
  private List<@Valid Student> data = new ArrayList<>();

  private Boolean success;

  private @Nullable String message;

  public GetAllStudentsResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetAllStudentsResponse(Boolean success) {
    this.success = success;
  }

  public GetAllStudentsResponse page(@Nullable Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Page number
   * @return page
   */
  
  @Schema(name = "page", example = "1", description = "Page number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("page")
  public @Nullable Integer getPage() {
    return page;
  }

  public void setPage(@Nullable Integer page) {
    this.page = page;
  }

  public GetAllStudentsResponse size(@Nullable Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Number of items
   * @return size
   */
  
  @Schema(name = "size", example = "10", description = "Number of items", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public @Nullable Integer getSize() {
    return size;
  }

  public void setSize(@Nullable Integer size) {
    this.size = size;
  }

  public GetAllStudentsResponse totalItems(@Nullable Integer totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  /**
   * Total items
   * @return totalItems
   */
  
  @Schema(name = "totalItems", example = "99", description = "Total items", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalItems")
  public @Nullable Integer getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(@Nullable Integer totalItems) {
    this.totalItems = totalItems;
  }

  public GetAllStudentsResponse totalPages(@Nullable Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Total pages
   * @return totalPages
   */
  
  @Schema(name = "totalPages", example = "10", description = "Total pages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPages")
  public @Nullable Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(@Nullable Integer totalPages) {
    this.totalPages = totalPages;
  }

  public GetAllStudentsResponse data(List<@Valid Student> data) {
    this.data = data;
    return this;
  }

  public GetAllStudentsResponse addDataItem(Student dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public List<@Valid Student> getData() {
    return data;
  }

  public void setData(List<@Valid Student> data) {
    this.data = data;
  }

  public GetAllStudentsResponse success(Boolean success) {
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

  public GetAllStudentsResponse message(@Nullable String message) {
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
    GetAllStudentsResponse getAllStudentsResponse = (GetAllStudentsResponse) o;
    return Objects.equals(this.page, getAllStudentsResponse.page) &&
        Objects.equals(this.size, getAllStudentsResponse.size) &&
        Objects.equals(this.totalItems, getAllStudentsResponse.totalItems) &&
        Objects.equals(this.totalPages, getAllStudentsResponse.totalPages) &&
        Objects.equals(this.data, getAllStudentsResponse.data) &&
        Objects.equals(this.success, getAllStudentsResponse.success) &&
        Objects.equals(this.message, getAllStudentsResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, size, totalItems, totalPages, data, success, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAllStudentsResponse {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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

