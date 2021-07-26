package com.example.blogapplicationextend.controller;

import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
import com.example.blogapplicationextend.model.service.BlogService;
import com.example.blogapplicationextend.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/blogs")
    public ModelAndView showBlogList(@RequestParam("keyWord") Optional<String> keyWord, @PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogs;
        String key = "";
        if (keyWord.isPresent()) {
            blogs = blogService.findAllByBlogNameContaining(keyWord.get(), pageable);
            key = keyWord.get();
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("keyWord", key);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blog.setDateCreate(LocalDate.now().toString());
//        blog.setDateCreate(LocalDate.now().plusYears(1).toString());

        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog created compliment");
        return modelAndView;
    }

    @GetMapping("/update-blog/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);

        if (blog == null) {
            return new ModelAndView("/error.404");
        }
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/update-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated compliment");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);

        if (blog == null) {
            return new ModelAndView("/error.404");
        }

        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());

        return "redirect:blogs";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView detailInformationBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);

        if (blog == null) {
            return new ModelAndView("/error.404");
        }

        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

}
