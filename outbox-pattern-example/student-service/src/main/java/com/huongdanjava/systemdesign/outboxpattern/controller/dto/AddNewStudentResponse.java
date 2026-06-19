package com.huongdanjava.systemdesign.outboxpattern.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddNewStudentResponse {

  private boolean success;
  private String message;

}
