package codegym.controller;

import codegym.model.bean.Customer;
import codegym.model.service.impl.ICustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = {"","/list"})
    public String index(Model model) {
        customerService.findAll();
        model.addAttribute("customerList", customerService.findAll());
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";

    }

    @PostMapping("create")
    public String save(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/list";
    }
}