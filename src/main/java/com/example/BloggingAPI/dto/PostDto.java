package com.example.BloggingAPI.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer postId;

    @Column(name="title")
    @Size(min=3, max=8, message = "must contain 3 to 8 characters")
    private String postTitle;

    @NotEmpty
    @Size(max=1000, message = "please be precise, it is too long")
    private String content;

    private Date postedDate;

    private String imgName;
    private CategoryDto category;

    private UserDto user;
}
