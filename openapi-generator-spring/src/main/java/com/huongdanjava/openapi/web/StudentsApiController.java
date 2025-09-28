package com.huongdanjava.openapi.web;

import com.huongdanjava.openapi.dto.AddNewStudentResponse;
import com.huongdanjava.openapi.dto.DeleteStudentResponse;
import com.huongdanjava.openapi.dto.GetAllStudentsResponse;
import com.huongdanjava.openapi.dto.GetStudentByIdResponse;
import com.huongdanjava.openapi.dto.InlineObject;
import com.huongdanjava.openapi.dto.InlineObject1;
import com.huongdanjava.openapi.dto.Student;
import com.huongdanjava.openapi.dto.UpdateStudentResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-28T20:02:15.238860+08:00[Asia/Singapore]", comments = "Generator version: 7.15.0")
@Controller
@RequestMapping("${openapi.studentManagementSystem.base-path:/api}")
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
