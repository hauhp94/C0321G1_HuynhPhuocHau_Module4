package com.example.controller;

import com.example.service.CalculatorService;
import com.example.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService ;
    @GetMapping("/")
    public String calculator(){
        return "calculator";
    }
    @PostMapping(value = "/convert")
   public String convert(@RequestParam("usd") int usd,@RequestParam("rate") int rate, Model model){
        int vnd = calculatorService.convert(usd,rate);
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        return "calculator";
    }

}
