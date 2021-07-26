package com.example.validateform.controller;

import com.example.validateform.dto.UserDto;
import com.example.validateform.model.entity.User;
import com.example.validateform.model.service.UserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserService userService;
    @GetMapping(value = {"","create"})
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("userDto",new UserDto());
            redirectAttributes.addFlashAttribute("message"," đăng kí thành công");
            return "redirect:/create";
        }
    }
}
