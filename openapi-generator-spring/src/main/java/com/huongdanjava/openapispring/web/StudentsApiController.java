package com.huongdanjava.openapispring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-18T10:29:18.203151+07:00[Asia/Ho_Chi_Minh]")
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
