package com.huongdanjava.springbootspringfox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @GetMapping(value = "findById")
    @ApiOperation(value = "Find student by id")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Success", response = String.class),
	        @ApiResponse(code = 422, message = "Student not found"),
	        @ApiResponse(code = 417, message = "Exception failed")
	    })
    public String findById(int id) {
        return "Khanh";
    }
}
