package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.ServiceDto;
import com.example.model.entity.*;
import com.example.model.repository.RentTypeRepository;
import com.example.model.repository.ServiceRepository;
import com.example.model.repository.ServiceTypeRepository;
import com.example.model.service.RentTypeService;
import com.example.model.service.ServiceService;
import com.example.model.service.ServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    RentTypeService rentTypeService;

    @GetMapping("/create")
    public String createCustomer(Model model) {
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
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
            List<ServiceType> serviceTypeList = serviceTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("serviceTypeList", serviceTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "/furama/service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            redirectAttributes.addFlashAttribute("message", "create success, service: " + service.getServiceName());
            return "redirect:/service/create";
        }
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable int id, Model model) throws SQLException {
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        ModelAndView modelAndView = new ModelAndView("furama/service/edit", "serviceDto", serviceService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws SQLException {
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<ServiceType> serviceTypeList = serviceTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("serviceTypeList", serviceTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "/furama/service/edit";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            redirectAttributes.addFlashAttribute("message", "update success, service id: " +service.getServiceId());
            return "redirect:/customer-service/list";
        }
    }
    @PostMapping("/delete")
    public String deleteService(@RequestParam int idServiceDelete, RedirectAttributes redirectAttributes) throws SQLException {
        String name = serviceService.findById(idServiceDelete).getServiceName();
        serviceService.remove(idServiceDelete);
        redirectAttributes.addFlashAttribute("message", "delete success customer "+name);
        return "redirect:/customer-service/list";
    }
}
