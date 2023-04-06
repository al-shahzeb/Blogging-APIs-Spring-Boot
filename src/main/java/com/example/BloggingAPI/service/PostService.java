package com.example.BloggingAPI.service;

import com.example.BloggingAPI.dto.PostDto;
import com.example.BloggingAPI.model.Post;

import java.util.List;

public interface PostService {

    //create a post and add it to post table
    PostDto addPost(PostDto post, Integer categoryId, Integer userId);


    //update a post
    PostDto updatePost(PostDto post, Integer postId);


    //get a post by postId
    PostDto getPost(Integer postId);


    //get all posts belonging to given category
    List<PostDto> postsBelongingToCategory(Integer categoryId);


    //get all posts posted by given user
    List<PostDto> postsPostedByUser(Integer userId);


    //delete post by postId
    void deletePost(Integer postId);


    //get all the posts
    List<PostDto> getAllPost(Integer number, Integer size);


    //get post by post title
    List<PostDto> getPostByTitle(String title);
}
