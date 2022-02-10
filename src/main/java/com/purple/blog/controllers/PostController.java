package com.purple.blog.controllers;

import com.purple.blog.dtos.PostRequest;
import com.purple.blog.entities.Post;
import com.purple.blog.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Post> publicar(@PathVariable("id") Long id) throws Exception {

        Optional<Post> optionalPost = this.postService.findById(id);
        if(optionalPost.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(this.postService.publicar(id), HttpStatus.OK);
    }

}
