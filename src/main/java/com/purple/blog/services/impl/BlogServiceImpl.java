package com.purple.blog.services.impl;

import com.purple.blog.dtos.BlogRequest;
import com.purple.blog.entities.Author;
import com.purple.blog.entities.Blog;
import com.purple.blog.repositories.AuthorRepository;
import com.purple.blog.repositories.BlogRepository;
import com.purple.blog.services.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Blog save(BlogRequest blogRequest) throws Exception {

        // Buscamos el autor y validamos si tiene 18 o mas edad
        var author = this.authorRepository
                .findById(blogRequest.getAuthor().getId())
                .orElseThrow(() -> new IllegalArgumentException("No existe el author con ese id"));

        if((diffDates(author.getBirthDate(), new Date())) < 18){
            throw new Exception("El author debe ser mayor o igual a 18 anios");
        }

        // Validamos cuantos blogs tiene el author
        int numeroBlogs = blogRepository.findByAuthor_Id(blogRequest.getAuthor().getId()).size();
        if(numeroBlogs > 3) {
            throw new Exception("El author debe tener maximo 3 blogs");
        }
        return blogRepository.save(this.blogDtoToBlog(blogRequest));
    }

    // Solo se actualizara el estado del blog
    @Override
    public Blog updateStatus(Long id, String estado) {
        var blog = blogRepository.findById(id).get();
        blog.setStatus(estado);
        return this.blogRepository.save(blog);
    }

    private long diffDates(Date fechaInicial, Date fechaFinal) {
        long diffInMillies = Math.abs(fechaFinal.getTime() - fechaInicial.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    private Blog blogDtoToBlog(BlogRequest blogRequest){
        Blog blog = new Blog();
        blog.setStatus(blogRequest.getStatus());
        blog.setName(blogRequest.getName());
        blog.setDescription(blogRequest.getDescription());
        blog.setUrl(blogRequest.getUrl());
        Author author = new Author();
        author.setId(blogRequest.getAuthor().getId());
        blog.setAuthor(author);
        return blog;
    }
}
