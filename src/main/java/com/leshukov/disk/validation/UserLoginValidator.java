package com.leshukov.disk.validation;

import com.leshukov.disk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<UserLoginConstraint, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UserLoginConstraint userLogin) {
    }

    @Override
    public boolean isValid(String userLogin, ConstraintValidatorContext cxt) {
        return (userRepository.findByLogin(userLogin) == null);
    }
}
