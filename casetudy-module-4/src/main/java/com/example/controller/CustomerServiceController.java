package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.entity.Contract;
import com.example.model.entity.ContractDetail;
import com.example.model.entity.Customer;
import com.example.model.entity.CustomerType;
import com.example.model.service.AttachServiceService;
import com.example.model.service.ContractDetailService;
import com.example.model.service.ContractService;
import com.example.model.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
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
    public String showContractList(@RequestParam("keyWord") Optional<String> keyWord,@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Contract> contracts;
        String key = "";
        if (keyWord.isPresent()) {
            contracts = contractService.findByContractEndDay(keyWord.get(), pageable);
            key = keyWord.get();
        }else {
            contracts = contractService.findAll(pageable);
        }
        model.addAttribute("contractList", contracts);
        model.addAttribute("keyWord", key);
        return "/furama/customer_service/list";
    }
}
