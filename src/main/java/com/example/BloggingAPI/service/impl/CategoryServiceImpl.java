package com.example.BloggingAPI.service.impl;

import com.example.BloggingAPI.dto.CategoryDto;
import com.example.BloggingAPI.exception.ResourceNotFoundException;
import com.example.BloggingAPI.model.Category;
import com.example.BloggingAPI.repository.CategoryRepository;
import com.example.BloggingAPI.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);
        Category cat = categoryRepository.save(category);
        return modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
        Category category = modelMapper.map(categoryDto,Category.class);

        Category categoryy = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category"," id ",categoryId));

        //setting id can be skipped
        categoryy.setCategoryId(categoryy.getCategoryId());

        categoryy.setCategoryTitle(category.getCategoryTitle());
        categoryy.setCategoryDesc(category.getCategoryDesc());

        Category cat =  categoryRepository.save(categoryy);
        return modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category"," id ",categoryId));
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category: categories)
            categoryDtos.add(modelMapper.map(category,CategoryDto.class));
        return categoryDtos;
    }

    @Override
    public void deleteCategory(int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category"," id ",categoryId));

        categoryRepository.delete(category);
    }
}
