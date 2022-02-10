package com.purple.blog.services.impl;

import com.purple.blog.dtos.CommentRequest;
import com.purple.blog.entities.Comment;
import com.purple.blog.entities.Post;
import com.purple.blog.repositories.CommentRepository;
import com.purple.blog.repositories.PostRepository;
import com.purple.blog.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public Comment save(CommentRequest commentRequest) throws Exception {
        // Buscamos el post y validamos si esta en estado activo
        var post = this.postRepository
                .findById(commentRequest.getPost().getId())
                .orElseThrow(() -> new IllegalArgumentException("No existe el Post con ese id"));

        if(post.getStatus().equals("borrador")) {
            throw new Exception("Solo se puede registrar comentarios en post en estado publicado");
        }

        return this.commentRepository.save(this.commentDtoToComment(commentRequest));
    }

    private Comment commentDtoToComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setDate(new Date());
        comment.setName(commentRequest.getName());
        Post post = new Post();
        post.setId(commentRequest.getPost().getId());
        comment.setPost(post);
        return comment;
    }
}
