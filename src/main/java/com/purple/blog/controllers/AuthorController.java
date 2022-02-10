package com.purple.blog.controllers;

import com.purple.blog.dtos.AuthorRequest;
import com.purple.blog.entities.Author;
import com.purple.blog.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author save(@RequestBody AuthorRequest authorRequest) throws Exception {
        return this.authorService.save(authorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.authorService.delete(id);
    }
}
