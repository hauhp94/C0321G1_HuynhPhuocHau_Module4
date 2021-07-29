package com.codegym.controller;

import com.codegym.model.entity.Cart;
import com.codegym.model.entity.Product;
import com.codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("clear")
    public String clearCart(@SessionAttribute("cart") Cart cart) {
        cart.clearCart();
        return "cart";
    }

    @GetMapping(value = {"/shop", ""})
    public ModelAndView showShop(@CookieValue(value = "idHistory", defaultValue = "-1") Long idHistory, Model model) {
        if (idHistory != -1) {
            model.addAttribute("historyProduct", productService.findById(idHistory).get());
        }
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/minus/{id}")
    public String minusProduct(@PathVariable Long id, @SessionAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.minusProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(@PathVariable long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idHistory", id + "");
        cookie.setMaxAge(60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", productService.findById(id).orElse(null));
        return modelAndView;

    }
}