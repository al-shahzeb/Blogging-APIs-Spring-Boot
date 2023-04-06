package com.example.BloggingAPI.service.impl;

import com.example.BloggingAPI.dto.PostDto;
import com.example.BloggingAPI.exception.ResourceNotFoundException;
import com.example.BloggingAPI.model.Category;
import com.example.BloggingAPI.model.Post;
import com.example.BloggingAPI.model.User;
import com.example.BloggingAPI.repository.CategoryRepository;
import com.example.BloggingAPI.repository.PostRepository;
import com.example.BloggingAPI.repository.UserRepository;
import com.example.BloggingAPI.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    @Override
    public PostDto addPost(PostDto postDto, Integer categoryId, Integer userId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category"," category id ",categoryId));
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User"," user id ",userId));

        Post post =this.modelMapper.map(postDto,Post.class);
        post.setPostedDate(new Date());
        post.setImgName("default.png");
        post.setCategory(category);
        post.setUser(user);

        Post p = postRepository.save(post);
        PostDto newPost = modelMapper.map(p,PostDto.class);
        return newPost;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post =  postRepository.findById(postId).orElseThrow(()->
                new ResourceNotFoundException("Post"," post id ",postId));

        Post changedPost = modelMapper.map(postDto,Post.class);
        post.setPostTitle(changedPost.getPostTitle());
        post.setContent(changedPost.getContent());
        Post updated = postRepository.save(post);
        return modelMapper.map(updated,PostDto.class);
    }

    @Override
    public PostDto getPost(Integer postId) {
        Post post =  postRepository.findById(postId).orElseThrow(()->
                new ResourceNotFoundException("Post"," post id ",postId));

        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> postsBelongingToCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category"," category id ",categoryId));

        List<Post> posts = postRepository.findByCategory(category);
        List<PostDto> postDtos = posts.stream().map((post)->modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> postsPostedByUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User"," user id ",userId));

        List<Post> posts = postRepository.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post)->modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(()->
                new ResourceNotFoundException("Post"," post id ",postId));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> postList = pagePost.getContent();

        return postList.stream().map((post)->modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByTitle(String title) {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();

        for(Post post:posts)
            if(post.getPostTitle().equals(title))
                postDtos.add(modelMapper.map(post,PostDto.class));

        if(postDtos.size()>0)
            return postDtos;
        throw new ResourceNotFoundException("Post"," post title "+title,0);
    }
}