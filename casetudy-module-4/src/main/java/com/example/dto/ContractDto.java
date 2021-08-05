package com.example.dto;

import com.example.model.entity.ContractDetail;
import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import com.example.model.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto implements Validator {
    private int id;
    @NotBlank
    private String contractStartDate;
    @NotBlank
    private String contractEndDate;
    @Min(0)
    private double contractDeposit;
    @Min(0)
    private double contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;


    }
}
