package com.leshukov.disk.service.impl;

import com.leshukov.disk.dto.IdDto;
import com.leshukov.disk.dto.UserDto;
import com.leshukov.disk.dto.UserRegistrationDto;
import com.leshukov.disk.entity.UserEntity;
import com.leshukov.disk.repository.RoleRepository;
import com.leshukov.disk.repository.UserRepository;
import com.leshukov.disk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(
                entity -> UserDto.builder()
                        .id(entity.getId())
                        .lastName(entity.getLastName())
                        .firstName(entity.getFirstName())
                        .middleName(entity.getMiddleName())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public UserDto findOne(Long userId) {
        return null;
    }

    @Override
    public UserDto findOne(String login) {
        UserEntity entity = userRepository.findByLogin(login);
        return UserDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }

    @Override
    public IdDto create(UserRegistrationDto userRegistrationDto) {
        UserEntity userEntity = UserEntity.builder()
                .password(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()))
                .login(userRegistrationDto.getLogin())
                .lastName(userRegistrationDto.getLastName())
                .firstName(userRegistrationDto.getFirstName())
                .middleName(userRegistrationDto.getMiddleName())
                .role(roleRepository.findByName("USER"))
                .build();

        return IdDto.builder().id(userRepository.save(userEntity).getId()).build();
    }

}
