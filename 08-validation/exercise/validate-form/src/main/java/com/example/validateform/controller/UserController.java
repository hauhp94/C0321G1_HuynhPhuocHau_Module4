package com.example.validateform.controller;

import com.example.validateform.model.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
@Controller
public class UserController {
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            return "result";
        }
    }
}
