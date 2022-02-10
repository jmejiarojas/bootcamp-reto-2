package com.purple.blog.dtos;

import com.purple.blog.entities.Author;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class BlogRequest {
    private String name;
    private String description;
    private String url;
    @Pattern(regexp = "activo|inactivo")
    private String status;
    private Author author;
}
