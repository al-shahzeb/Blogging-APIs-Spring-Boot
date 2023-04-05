package com.example.BloggingAPI.controller;

import com.example.BloggingAPI.model.Category;
import com.example.BloggingAPI.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category){
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category,
                                                   @PathVariable("categoryId")Integer categoryId) {
        return new ResponseEntity<>(categoryService.updateCategory(category,categoryId),HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Category> getCategoryById(@RequestParam("categoryId")Integer categoryId) {
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId),HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteCategory(@RequestParam("categoryId")Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("Category deleted successfully",HttpStatus.CREATED);
    }
}
