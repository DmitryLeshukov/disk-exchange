package com.leshukov.disk.service;

import com.leshukov.disk.dto.IdDto;
import com.leshukov.disk.dto.UserDto;
import com.leshukov.disk.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findOne(Long bookId);

    UserDto findOne(String login);

    IdDto create(UserRegistrationDto bookDto);
}
