package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.bean.EmailSetting;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailSettingController {
    @GetMapping("/home")
    public ModelAndView home(Model model) {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Chinese");
        languages.add("Japanese");
        model.addAttribute("languages",languages);
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        model.addAttribute("pageSize",pageSize);
        return new ModelAndView("home","setting",new EmailSetting());
    }
    @PostMapping("/create")
    public ModelAndView login(@ModelAttribute("emailSetting") EmailSetting emailSetting){
     return new ModelAndView("result");
    }
}
