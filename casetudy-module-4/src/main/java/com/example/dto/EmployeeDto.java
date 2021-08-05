package com.example.dto;

import com.example.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Validator {
    private int employeeId;
    @NotBlank
    private String employeeName;
    @NotBlank
    private String employeeBirthday;
    @NotBlank
    private String employeeIdCard;
    @Min(1)
    private double employeeSalary;
    @NotBlank
    private String employeePhone;
    @Email
    private String employeeEmail;
    @NotBlank
    private String employeeAddress;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private AppUser appUser;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String patternPhone = "(09[0,1]\\d{7})|(\\(84\\)9[0,1]\\d{7})";
        if (!java.util.regex.Pattern.matches(patternPhone, employeeDto.employeePhone)) {
            errors.rejectValue("employeePhone", "customerPhone.matches");
        }

    }

}
