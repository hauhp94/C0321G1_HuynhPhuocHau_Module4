package com.example.blogapplicationextend.controller;


import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
import com.example.blogapplicationextend.model.service.BlogService;
import com.example.blogapplicationextend.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ModelAndView ShowListBlog() {
        Iterable<Category> categories = categoryService.findAll();

        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category created compliment");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);

        if (category == null) {
            return new ModelAndView("/error.404");
        }
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated compliment");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);

        if (category == null) {
            return new ModelAndView("/error.404");
        }

        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.remove(category.getId());

        return "redirect:categorys";
    }

    @GetMapping("/view/{id}")
    public ModelAndView detailInformationCategory(@PathVariable Long id,@PageableDefault(value = 3) Pageable pageable) {
        Category category = categoryService.findById(id);

        if (category == null) {
            return new ModelAndView("/error.404");
        }

        Page<Blog> blogs = blogService.findAllByCategory(category,pageable);

        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("category", category);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}
