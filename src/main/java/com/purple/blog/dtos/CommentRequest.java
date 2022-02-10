package com.purple.blog.dtos;

import com.purple.blog.entities.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private String name;
    private Post post;
}
