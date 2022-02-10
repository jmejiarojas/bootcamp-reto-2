package com.purple.blog.services;

import com.purple.blog.dtos.PostRequest;
import com.purple.blog.entities.Post;

import java.util.Optional;

public interface PostService {
    Post save(PostRequest postRequest) throws Exception;
    Post publicar(Long id) throws Exception;
    Optional<Post> findById(Long id);
}
