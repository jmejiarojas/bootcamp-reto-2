package com.purple.blog.dtos;

import com.purple.blog.entities.Blog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private String title;
    private String content;
    private Blog blog;
}
