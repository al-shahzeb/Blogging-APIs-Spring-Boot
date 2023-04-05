package com.example.BloggingAPI.service.impl;

import com.example.BloggingAPI.exception.ResourceNotFoundException;
import com.example.BloggingAPI.model.Category;
import com.example.BloggingAPI.repository.CategoryRepository;
import com.example.BloggingAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(Category category, int categoryId) {
        Category categoryy = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category"," id ",categoryId));

        //setting id can be skipped
        categoryy.setCategoryId(categoryy.getCategoryId());

        categoryy.setCategoryTitle(category.getCategoryTitle());
        categoryy.setCategoryDesc(category.getCategoryDesc());

        return categoryRepository.save(categoryy);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category"," id ",categoryId));
        return category;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category"," id ",categoryId));

        categoryRepository.delete(category);
    }
}
