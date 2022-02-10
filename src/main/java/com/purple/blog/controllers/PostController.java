package com.purple.blog.controllers;

import com.purple.blog.dtos.PostRequest;
import com.purple.blog.entities.Post;
import com.purple.blog.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post save(@RequestBody PostRequest postRequest) throws Exception {
        return this.postService.save(postRequest);
    }

    @PutMapping("/{id}")
    public Post publicar(@PathVariable("id") Long id) throws Exception {
        return this.postService.publicar(id);
    }

}
