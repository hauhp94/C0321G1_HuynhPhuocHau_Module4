package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.entity.Customer;
import com.example.model.entity.CustomerType;
import com.example.model.service.CustomerService;
import com.example.model.service.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerTypeService customerTypeService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/create")
    public String createCustomer(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", new CustomerDto());
        return "/furama/customer/create";
    }

    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "/furama/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "create success, customer: " + customer.getCustomerName());
            return "redirect:/customer/list";
        }


    }

    @GetMapping("/list")
    public String showCustomerList(@RequestParam("keyWord") Optional<String> keyWord, @PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Customer> customers;
        String key = "";
        if (keyWord.isPresent()) {
            customers = customerService.findByName(keyWord.get(), pageable);
            key = keyWord.get();
        } else {
            customers = customerService.findAll(pageable);
        }

        model.addAttribute("customerList", customers);
        model.addAttribute("keyWord", key);
        return "/furama/customer/list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam int idCustomerDelete, RedirectAttributes redirectAttributes) throws SQLException {
        String name = customerService.findById(idCustomerDelete).getCustomerName();
        customerService.remove(idCustomerDelete);
        redirectAttributes.addFlashAttribute("message", "delete success customer "+name);
        return "redirect:/customer/list";
    }

    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws SQLException {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "/furama/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "update success, customer: " + customer.getCustomerName());
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable int id, Model model) throws SQLException {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        ModelAndView modelAndView = new ModelAndView("furama/customer/edit", "customerDto", customerService.findById(id));
        return modelAndView;
    }

}
