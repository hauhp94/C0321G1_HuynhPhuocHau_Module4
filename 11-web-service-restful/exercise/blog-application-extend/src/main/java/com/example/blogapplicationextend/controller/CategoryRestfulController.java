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

import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
public class CategoryRestfulController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @GetMapping("list-blog/{id}") //list block theo id category
    public ResponseEntity<List<Blog>> getBlockListByCategory(@PathVariable Long id) {
        List<Blog> blogs = blogService.findAllByCategory(categoryService.findById(id));
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if(category==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCategory(@PathVariable Long id,@RequestBody Category category) {
        Category currentCategory = categoryService.findById(id);
        if(currentCategory==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCategory.setBlogs(category.getBlogs());
        currentCategory.setCategoryName(category.getCategoryName());
        categoryService.save(currentCategory);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        Category currentCategory = categoryService.findById(id);
        if(currentCategory==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
