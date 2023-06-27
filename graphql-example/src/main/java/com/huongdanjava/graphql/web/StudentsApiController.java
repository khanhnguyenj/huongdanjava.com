package com.huongdanjava.graphql.web;

import com.huongdanjava.graphql.dto.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-27T15:23:22.901157-04:00[America/New_York]")
@Controller
@RequestMapping("${openapi.studentInformationManagementSystem.base-path:/api}")
public class StudentsApiController implements StudentsApi {

    private final StudentsApiDelegate delegate;

    public StudentsApiController(@Autowired(required = false) StudentsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new StudentsApiDelegate() {});
    }

    @Override
    public StudentsApiDelegate getDelegate() {
        return delegate;
    }

}
