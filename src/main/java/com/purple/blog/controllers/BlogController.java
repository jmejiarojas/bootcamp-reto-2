package com.purple.blog.controllers;

import com.purple.blog.dtos.BlogRequest;
import com.purple.blog.entities.Blog;
import com.purple.blog.services.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;


@RestController
@RequestMapping("blogs")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public Blog save(@RequestBody BlogRequest blog) throws Exception {
        return this.blogService.save(blog);
    }

    @PutMapping("/{id}")
    public Blog updateStatus(@PathVariable("id") Long id, @Pattern(regexp = "activo|inactivo") @RequestParam String estado){
        return this.blogService.updateStatus(id, estado);
    }

}
