package com.example.dto;

import com.example.model.entity.CustomerType;
import com.example.model.repository.CustomerRepository;
import com.example.model.service.CustomerService;
import com.example.model.service.implement.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Component
public class CustomerDto implements Validator {
//    @Autowired
//    CustomerService customerService;

    private int customerId;
    @NotBlank
    private String customerCode;
    private CustomerType customerType;
    @NotBlank
    private String customerName;
    @NotBlank
    private String customerBirthday;
    private int customerGender;
    @NotBlank
    private String customerIdCard;
    @NotBlank
    private String customerPhone;
    @Email
    @NotBlank
    private String customerEmail;
    @NotBlank
    private String customerAddress;
    private int serviceId;
    private int contractDetailId;
    private int quantity;
    private String attach_service_name;


    public CustomerDto(int customerId, String customerCode, CustomerType customerType,
                       String customerName, String customerBirthday, int customerGender,
                       String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String patternCode = "^KH-\\d{4}";
        if (!java.util.regex.Pattern.matches(patternCode, customerDto.customerCode)) {
            errors.rejectValue("customerCode", "customerCode.matches");
        }
        String patternIdCard = "^(\\d{9})|(\\d{12})";
        if (!java.util.regex.Pattern.matches(patternIdCard, customerDto.customerIdCard)) {
            errors.rejectValue("customerIdCard", "customerIdCard.matches");
        }
        String patternPhone = "(09[0,1]\\d{7})|(\\(84\\)9[0,1]\\d{7})";
        if (!java.util.regex.Pattern.matches(patternPhone, customerDto.customerPhone)) {
            errors.rejectValue("customerPhone", "customerPhone.matches");
        }

//        if (customerService.isExistCustomerCode(customerDto.customerCode)){
//            errors.rejectValue("customerCode","customerCode.exist");
//        }
//        if (true){
//            errors.rejectValue("customerCode","customerCode.exist");
//        }

    }
}
