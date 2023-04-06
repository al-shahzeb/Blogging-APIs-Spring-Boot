package com.example.BloggingAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {

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

    @ManyToOne
    @JoinColumn(name = "belongs_to_category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "posted_by_user_id")
    private User user;


}
