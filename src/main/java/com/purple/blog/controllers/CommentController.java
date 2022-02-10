package com.purple.blog.controllers;

import com.purple.blog.dtos.CommentRequest;
import com.purple.blog.entities.Comment;
import com.purple.blog.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Comment save(@RequestBody CommentRequest commentRequest) throws Exception {
        return this.commentService.save(commentRequest);
    }

}
