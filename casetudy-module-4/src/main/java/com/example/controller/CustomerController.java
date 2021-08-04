package com.example.controller;

import com.example.model.entity.Customer;
import com.example.model.entity.CustomerType;
import com.example.model.service.CustomerService;
import com.example.model.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerTypeService customerTypeService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute(value = "customer") Customer customer, Model model) {
        ModelAndView modelAndView = new ModelAndView("/furama/customer/create", "customer", new Customer());
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        System.out.println(customer.getCustomer_birthday());
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "create success, customer: " + customer.getCustomer_name());
        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String showCustomerList(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "/furama/customer/list";
    }
}
