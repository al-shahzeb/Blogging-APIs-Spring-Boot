package com.example.BloggingAPI.service;

import com.example.BloggingAPI.dto.CategoryDto;
import com.example.BloggingAPI.model.Category;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto addCategory(CategoryDto category);

    //update
    CategoryDto updateCategory(CategoryDto category, int categoryId);

    //getById
    CategoryDto getCategoryById(int categoryId);

    //getAll
    List<CategoryDto> getCategories();

    //delete
    void deleteCategory(int categoryId);
}
