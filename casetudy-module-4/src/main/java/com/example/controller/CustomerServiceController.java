package com.example.controller;

import com.example.model.entity.Customer;
import com.example.model.service.AttachServiceService;
import com.example.model.service.ContractDetailService;
import com.example.model.service.ContractService;
import com.example.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("customer-service")
public class CustomerServiceController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachServiceService;
    @Autowired
    ContractDetailService contractDetailService;

    @GetMapping("/list")
    public String showCustomerList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Customer> customers = customerService.findAllCustomerUseService(pageable);
        model.addAttribute("customerList", customers);
        return "/furama/customer_service/list";
    }
}
