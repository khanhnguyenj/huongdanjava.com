package com.huongdanjava.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String hello() {
        return "home";
    }
}