package com.purple.blog.services.impl;

import com.purple.blog.dtos.AuthorRequest;
import com.purple.blog.entities.Author;
import com.purple.blog.repositories.AuthorRepository;
import com.purple.blog.repositories.BlogRepository;
import com.purple.blog.repositories.CommentRepository;
import com.purple.blog.repositories.PostRepository;
import com.purple.blog.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImp implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BlogRepository blogRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public Author save(AuthorRequest authorRequest) {
        return this.authorRepository.save(this.authorRequestToAuthor(authorRequest));
    }

    @Override
    public void delete(Long id) {
        this.authorRepository.deleteById(id);
    }

    private Author authorRequestToAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setNombre(authorRequest.getName());
        author.setEmail(authorRequest.getEmail());
        author.setPhone(authorRequest.getName());
        author.setBirthDate(authorRequest.getBirthDate());
        return author;
    }
}
