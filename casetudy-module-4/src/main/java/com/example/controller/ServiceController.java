package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.ServiceDto;
import com.example.model.entity.*;
import com.example.model.repository.RentTypeRepository;
import com.example.model.repository.ServiceRepository;
import com.example.model.repository.ServiceTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    RentTypeRepository rentTypeRepository;

    @GetMapping("/create")
    public String createCustomer(Model model) {
        List<ServiceType> serviceTypeList = serviceTypeRepository.findAll();
        List<RentType> rentTypeList = rentTypeRepository.findAll();
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("serviceDto", new ServiceDto());
        return "/furama/service/create";
    }

    @PostMapping("/create")
    public String saveService(@Valid @ModelAttribute ServiceDto serviceDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<ServiceType> serviceTypeList = serviceTypeRepository.findAll();
            List<RentType> rentTypeList = rentTypeRepository.findAll();
            model.addAttribute("serviceTypeList", serviceTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "/furama/service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceRepository.save(service);
            redirectAttributes.addFlashAttribute("message", "create success, service: " + service.getServiceName());
            return "redirect:/service/create";
        }
    }
}
