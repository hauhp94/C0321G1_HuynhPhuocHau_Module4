package com.example.validateform.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Validator {
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;

    private int age;
    @Email
    @NotBlank
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDTO = (UserDto) target;
        if (userDTO.firstName.trim().length() < 5 || userDTO.firstName.trim().length() > 45) {
            errors.rejectValue("firstName", "firstName.length");
        }
        if (userDTO.firstName.trim().equals("admin")) {
            errors.rejectValue("firstName", "firstName.admin");
        }
        if (userDTO.lastName.trim().equals("admin")) {
            errors.rejectValue("lastName", "lastName.admin");
        }
        if (userDTO.lastName.trim().length() < 5 || userDTO.lastName.trim().length() > 45) {
            errors.rejectValue("lastName", "lastName.length");
        }
        String patternPhoneNumber = "^0\\d{8,9}$";
        if (!Pattern.matches(patternPhoneNumber, userDTO.phoneNumber)) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        if (userDTO.age < 18) {
            errors.rejectValue("age", "age.not18");
        }
    }
}
