package com.leshukov.disk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/registration")
    public String registration() {
        return "security/registration";
    }

    @GetMapping("/login")
    public String login() {
        return "security/login";
    }
}
