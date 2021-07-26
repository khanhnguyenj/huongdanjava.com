package com.huongdanjava.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/user/view")
    public String userView() {
        return "user";
    }

    @GetMapping("/admin/view")
    public String adminView() {
        return "admin";
    }

    @GetMapping("/user-login")
    public String userLoginView() {
        return "login-user";
    }

}
