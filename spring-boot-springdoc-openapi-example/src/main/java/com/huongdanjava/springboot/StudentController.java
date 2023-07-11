package com.huongdanjava.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

  @GetMapping(value = "findById")
  @Operation(summary = "Find student by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success"),
      @ApiResponse(responseCode = "422", description = "Student not found"),
      @ApiResponse(responseCode = "417", description = "Exception failed")
  })
  public String findById(int id) {
    return "Khanh";
  }
}
