package com.example.BloggingAPI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PostResponse {

    private List<PostDto> content;
    private Integer currPage;
    private Integer pageSize;
    private Integer totalPages;
    private Long contentSize;

}
