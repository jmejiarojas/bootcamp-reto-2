package com.purple.blog.services;

import com.purple.blog.dtos.AuthorRequest;
import com.purple.blog.entities.Author;

public interface AuthorService {

    Author save (AuthorRequest autor);
    void delete(Long id);
}
