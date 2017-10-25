package com.leshukov.disk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leshukov.disk.validation.PasswordMatch;
import com.leshukov.disk.validation.UserLoginConstraint;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@PasswordMatch(
        field = "password",
        fieldMatch = "passwordConfirm",
        message = "Passwords do not match!"
)
public class UserRegistrationDto {

    @NotBlank(message = "Enter login")
    @UserLoginConstraint
    private String login;

    @NotBlank(message = "Enter last name")
    private String lastName;

    @NotBlank(message = "Enter first name")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Enter password")
    @Length(min = 8, message = "Password minimal length is 8")
    private String password;

    @NotBlank(message = "Enter password confirm")
    private String passwordConfirm;
}
