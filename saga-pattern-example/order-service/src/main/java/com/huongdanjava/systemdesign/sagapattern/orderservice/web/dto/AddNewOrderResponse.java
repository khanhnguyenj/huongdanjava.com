package com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * AddNewOrderResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-04T12:52:53.676943+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.23.0")
public class AddNewOrderResponse {

  private Boolean success;

  private @Nullable String message;

  private @Nullable Order data;

  public AddNewOrderResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AddNewOrderResponse(Boolean success) {
    this.success = success;
  }

  public AddNewOrderResponse success(Boolean success) {
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

  @JsonProperty("success")
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public AddNewOrderResponse message(@Nullable String message) {
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

  @JsonProperty("message")
  public void setMessage(@Nullable String message) {
    this.message = message;
  }

  public AddNewOrderResponse data(@Nullable Order data) {
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
  public @Nullable Order getData() {
    return data;
  }

  @JsonProperty("data")
  public void setData(@Nullable Order data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddNewOrderResponse addNewOrderResponse = (AddNewOrderResponse) o;
    return Objects.equals(this.success, addNewOrderResponse.success) &&
        Objects.equals(this.message, addNewOrderResponse.message) &&
        Objects.equals(this.data, addNewOrderResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddNewOrderResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

