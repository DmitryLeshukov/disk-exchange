package com.leshukov.disk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("user")
    public String userList() {
        return "user/user-list";
    }
}
