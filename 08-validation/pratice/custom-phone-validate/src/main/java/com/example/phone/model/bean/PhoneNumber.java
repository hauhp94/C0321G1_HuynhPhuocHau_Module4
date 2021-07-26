package com.example.phone.model.bean;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PhoneNumber implements Validator {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length","loi 10-11 so");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith","loi bat dau tu 0");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches","loi khong phai so");
        }
    }
}
