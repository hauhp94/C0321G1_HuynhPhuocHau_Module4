package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.model.service.DictionaryService;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/")
    public String calculator() {
        return "index";
    }

    @PostMapping(value = "/translate")
    public String convert(@RequestParam("key") String key, Model model) {
        String result = dictionaryService.translate(key);
        model.addAttribute("result", result);
        return "index";
    }
}
