package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.model.service.CalculatorService;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(@RequestParam double firstNumber, @RequestParam double secondNumber, @RequestParam String operator, Model model) {
        String result = calculatorService.calculator(firstNumber, secondNumber, operator);
        model.addAttribute("result", result);
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("operator", operator);

        return "index";
    }
}
