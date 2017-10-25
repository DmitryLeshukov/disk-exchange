package com.leshukov.disk.controller.rest;


import com.leshukov.disk.dto.IdDto;
import com.leshukov.disk.dto.UserDto;
import com.leshukov.disk.dto.UserRegistrationDto;
import com.leshukov.disk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author dleshukov@alvioneurope.ru
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public UserDto findOne(@PathVariable Long userId) {
        return userService.findOne(userId);
    }

    @PostMapping
    public IdDto createUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        return userService.create(userRegistrationDto);
    }

}
