package com.purple.blog.services.impl;

import com.purple.blog.dtos.AuthorRequest;
import com.purple.blog.entities.Author;
import com.purple.blog.entities.Blog;
import com.purple.blog.entities.Comment;
import com.purple.blog.entities.Post;
import com.purple.blog.repositories.AuthorRepository;
import com.purple.blog.repositories.BlogRepository;
import com.purple.blog.repositories.CommentRepository;
import com.purple.blog.repositories.PostRepository;
import com.purple.blog.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BlogRepository blogRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public Author save(AuthorRequest authorRequest) {
        return this.authorRepository.save(this.authorRequestToAuthor(authorRequest));
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Author author = this.authorRepository.findById(id).get();
        //Buscamos todos los blogs del Autor
        List<Blog> blogs = this.blogRepository.findByAuthor_Id(author.getId());

        System.out.println(blogs);

        Map<Long, List<Post>> mapBlog = blogs.stream()
                .collect(Collectors.toMap(Blog::getId, Blog::getPosts));

        mapBlog.forEach((aLong, posts) ->
        {
            Map<Long, List<Comment>> mapComment = posts.stream().collect(Collectors.toMap(post -> post.getId(), post -> post.getComments()));
            mapComment.forEach((aLong1, comments) -> this.commentRepository.deleteAll(comments));
            this.postRepository.deleteAll(posts);
        });

        this.blogRepository.deleteAll(blogs);
        this.authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    private Author authorRequestToAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setEmail(authorRequest.getEmail());
        author.setPhone(authorRequest.getName());
        author.setBirthDate(authorRequest.getBirthDate());
        return author;
    }
}
