package com.purple.blog.controllers;

import com.purple.blog.dtos.BlogRequest;
import com.purple.blog.entities.Blog;
import com.purple.blog.services.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;


@RestController
@RequestMapping("blogs")
@Validated
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public Blog save(@RequestBody @Valid BlogRequest blog) throws Exception {
        return this.blogService.save(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateStatus(@PathVariable("id") Long id, @Pattern(regexp = "activo|inactivo") @RequestParam String estado){

        return this.blogService.findById(id)
                .map(blog -> new ResponseEntity<>(this.blogService
                        .updateStatus(id, estado), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
