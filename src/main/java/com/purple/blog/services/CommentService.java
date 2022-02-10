package com.purple.blog.services;

import com.purple.blog.dtos.CommentRequest;
import com.purple.blog.entities.Comment;

public interface CommentService {
    Comment save(CommentRequest comment) throws Exception;
}
