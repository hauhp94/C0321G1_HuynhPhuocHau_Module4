package com.example.controller;

import com.example.dto.ContractDto;
import com.example.dto.ServiceDto;
import com.example.model.entity.*;
import com.example.model.repository.RentTypeRepository;
import com.example.model.repository.ServiceRepository;
import com.example.model.repository.ServiceTypeRepository;
import com.example.model.service.*;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ContractService contractService;

    @GetMapping("/create")
    public String createContract(Model model) {
        this.getListSecondary(model);
        model.addAttribute("contractDto", new ContractDto());
        return "/furama/contract/create";
    }

    private void getListSecondary(Model model) {
        List<Service> serviceList = serviceService.findAll();
        List<Customer> customerList = customerService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("employeeList", employeeList);
    }

    @PostMapping("/create")
    public String saveService(@Valid @ModelAttribute ContractDto contractDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws Exception {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            this.getListSecondary(model);
            return "/furama/contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contract.setContractTotalMoney(contract.getService().serviceCost);
            contractService.save(contract);
            Customer customer = contractDto.getCustomer();
            customer.setServiceId(contractDto.getService().getServiceId());
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "create success contract start day in " + contract.getContractStartDate());
            return "redirect:/contract/create";
        }
    }
}
