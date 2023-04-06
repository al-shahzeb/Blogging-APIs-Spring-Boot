package com.example.BloggingAPI.controller;

import com.example.BloggingAPI.dto.PostDto;
import com.example.BloggingAPI.dto.PostResponse;
import com.example.BloggingAPI.service.impl.PostServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @PostMapping("/add/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> addPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId,
                                        @PathVariable Integer categoryId){
        return new ResponseEntity<>(postService.addPost(postDto,categoryId,userId), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize){
        return new ResponseEntity<>(postService.getAllPost(pageNumber,pageSize),HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer postId){
        return new ResponseEntity<>(postService.getPost(postId),HttpStatus.CREATED);
    }

    @GetMapping("/get-by-title/{title}")
    public ResponseEntity<List<PostDto>> getPostByTitle(@PathVariable String title){
        return new ResponseEntity<>(postService.getPostByTitle(title),HttpStatus.CREATED);
    }

    @GetMapping("/get-posts-by-category/{categoryId}")
    public ResponseEntity<List<PostDto>> postsBelongingToCategory(@PathVariable Integer categoryId){
        return new ResponseEntity<>(postService.postsBelongingToCategory(categoryId),HttpStatus.CREATED);
    }

    @GetMapping("/get-posts-by-user/{userId}")
    public ResponseEntity<List<PostDto>> postsPostedByUser(@PathVariable Integer userId){
        return new ResponseEntity<>(postService.postsPostedByUser(userId),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ResponseEntity<>("Post deleted",HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId){
        return new ResponseEntity<>(postService.updatePost(postDto,postId),HttpStatus.CREATED);
    }
}
