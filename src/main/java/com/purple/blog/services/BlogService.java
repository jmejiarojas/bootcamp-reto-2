package com.purple.blog.services;

import com.purple.blog.dtos.BlogRequest;
import com.purple.blog.entities.Blog;

public interface BlogService {
    Blog save (BlogRequest blog) throws Exception;
    Blog update(Long id, String estado);
}
