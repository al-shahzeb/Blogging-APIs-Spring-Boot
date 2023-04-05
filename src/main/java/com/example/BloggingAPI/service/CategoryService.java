package com.example.BloggingAPI.service;

import com.example.BloggingAPI.model.Category;

import java.util.List;

public interface CategoryService {

    //create
    Category addCategory(Category category);

    //update
    Category updateCategory(Category category, int categoryId);

    //getById
    Category getCategoryById(int categoryId);

    //getAll
    List<Category> getCategories();

    //delete
    void deleteCategory(int categoryId);
}
