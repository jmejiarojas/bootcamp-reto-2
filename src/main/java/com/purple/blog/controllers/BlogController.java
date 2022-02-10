package com.purple.blog.controllers;

import com.purple.blog.dtos.BlogRequest;
import com.purple.blog.entities.Blog;
import com.purple.blog.services.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blogs")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public Blog save(@RequestBody BlogRequest blog) throws Exception {
        return this.blogService.save(blog);
    }

}
