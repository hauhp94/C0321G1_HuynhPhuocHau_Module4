package com.example.blogapplicationextend.controller;

import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog/v1")
public class BlogRestfulController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
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

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        blogService.save(blog);
       return new ResponseEntity<>(blog,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id,@RequestBody Blog blog) {
       Blog currentBlog = blogService.findById(id);
       if(currentBlog==null){
           return new ResponseEntity<>(currentBlog,HttpStatus.NOT_FOUND);
       }
       currentBlog.setBlogName(blog.getBlogName());
        currentBlog.setCategory(blog.getCategory());
        currentBlog.setContent(blog.getContent());
        currentBlog.setDateCreate(blog.getDateCreate());
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        Blog currentBlog = blogService.findById(id);
        if(currentBlog==null){
            return new ResponseEntity<>(currentBlog,HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<>(currentBlog,HttpStatus.OK);
    }


}
