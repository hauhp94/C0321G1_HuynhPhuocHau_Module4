package com.example.dto;

import com.example.model.entity.RentType;
import com.example.model.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto implements Validator {
    public int serviceId;
    public String serviceCode;
    @NotBlank
    public String serviceName;
    @Min(0)
    public int serviceArea;

    @Min(0)
    public double serviceCost;
    @Min(1)
    public int serviceMaxPeople;
    public RentType rentType;
    public ServiceType serviceType;
    @NotBlank
    public String standardRoom;
    @NotBlank
    public String descriptionOtherConvenience;

    @Min(10)
    public double poolArea;
    @Min(1)
    public int numberOfFloors;
    @NotBlank
    public String freeService;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        String patternCode = "^DV-\\d{4}";
        if (!java.util.regex.Pattern.matches(patternCode, serviceDto.serviceCode)) {
            errors.rejectValue("serviceCode", "serviceCode.matches");
        }
    }
}
