package com.purple.blog.services;

import com.purple.blog.dtos.AuthorRequest;
import com.purple.blog.entities.Author;

import java.util.Optional;

public interface AuthorService {

    Author save (AuthorRequest autor);
    void delete(Long id);
    Optional<Author> findById(Long id);
}
