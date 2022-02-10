package com.purple.blog.services;

import com.purple.blog.dtos.BlogRequest;
import com.purple.blog.entities.Blog;

import java.util.Optional;

public interface BlogService {
    Blog save (BlogRequest blog) throws Exception;
    Blog updateStatus(Long id, String estado);
    Optional<Blog> findById(Long id);
}
