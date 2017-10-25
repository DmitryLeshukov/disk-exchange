package com.leshukov.disk.controller.rest;

import com.leshukov.disk.dto.UserDto;
import com.leshukov.disk.dto.UserRegistrationDto;
import com.leshukov.disk.service.SecurityService;
import com.leshukov.disk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SecurityRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/registration")
    public ResponseEntity<Object> registration(@Valid @RequestBody UserRegistrationDto userRegistrationDto, Errors errors) {

        if(errors.hasErrors()){
            List<String> errorsList = errors.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorsList);
        }

        userService.create(userRegistrationDto);
        securityService.autologin(userRegistrationDto.getLogin(), userRegistrationDto.getPassword());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/info")
    public String getUserInfo(Principal principal) {
        if (principal != null) {
            UserDto dto = userService.findOne(principal.getName());
            return dto.getFirstName() + " " + dto.getLastName();
        }
        return null;
    }
}
