package com.example.blogapplicationextend.controller;

import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.service.BlogService;
import com.example.blogapplicationextend.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1")
public class BlogRestfulController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ModelAndView getAllBlog() {
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogService.findAll());
        return modelAndView;
    }


    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList(Pageable pageable) {
        List<Blog> blogs = blogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> getBlogSearch(@PathVariable String name) {
        List<Blog> blogs = blogService.findAllByBlogNameContaining(name);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

}
