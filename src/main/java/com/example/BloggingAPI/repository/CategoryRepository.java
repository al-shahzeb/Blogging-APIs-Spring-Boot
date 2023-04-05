package com.example.BloggingAPI.repository;

import com.example.BloggingAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
