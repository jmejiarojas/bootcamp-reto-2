package com.purple.blog.dtos;

import com.purple.blog.entities.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogRequest {
    private String name;
    private String description;
    private String url;
    private String status;
    private Author author;
}
