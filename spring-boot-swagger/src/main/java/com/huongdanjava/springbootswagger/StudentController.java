package com.huongdanjava.springbootswagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @ApiOperation(value = "Find student by id")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = String.class),
        @ApiResponse(code = 422, message = "Student not found"),
        @ApiResponse(code = 417, message = "Exception failed")
    })
    public String findById() {
        return "Khanh";
    }
}
