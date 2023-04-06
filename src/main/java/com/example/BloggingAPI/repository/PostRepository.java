package com.example.BloggingAPI.repository;

import com.example.BloggingAPI.model.Category;
import com.example.BloggingAPI.model.Post;
import com.example.BloggingAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
