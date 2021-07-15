package vn.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment",required = false) String[] condiment, Model model) {
        model.addAttribute("result",condiment);
        return "index";
    }
}
