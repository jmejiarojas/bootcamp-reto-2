package com.purple.blog.services.impl;

import com.purple.blog.dtos.PostRequest;
import com.purple.blog.entities.Blog;
import com.purple.blog.entities.Post;
import com.purple.blog.repositories.BlogRepository;
import com.purple.blog.repositories.PostRepository;
import com.purple.blog.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final BlogRepository blogRepository;
    private boolean aBoolean;

    // Los posts se registran siempre en estado borrador, asi que por dia se puede tener mas de un post siempre y cuando esten en borradores.
    @Override
    public Post save(PostRequest postRequest) throws Exception {

        // Buscamos el blog y validamos si esta en estado activo
        var blog = this.blogRepository
                .findById(postRequest.getBlog().getId())
                .orElseThrow(() -> new IllegalArgumentException("No existe el Blog con ese id"));

        if(blog.getStatus().equals("inactivo")) {
            throw new Exception("Solo se puede registrar posts en blogs con estado activo");
        }

        // Por regla de negocio los blog se registran en estado "borrador"
        return this.postRepository.save(this.postDtoToPost(postRequest));
    }

    // Par publicar un post o poner estado "publicado" se actualiza el estado del post, es la unica forma, es mi regla de negocio
    @Override
    public Post publicar(Long id) throws Exception {

        // Regla de negocio: Solo se puede publicar un post por dia
        var post = this.postRepository.findById(id).get();

        List<Post> postList = this.postRepository.findByStatusEquals("publicado");

         if(postList.stream().anyMatch(x -> sameDay(x.getDate(), new Date()))){
             throw new Exception("Solo se puede publicar un post por dia");
         }

        post.setStatus("publicado");
        return this.postRepository.save(post);
    }

    // La fecha no deberia ser ingresada por el usuario, ya que la fecha es la del dia
    private Post postDtoToPost(PostRequest postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setStatus("borrador");
        post.setContent(postDto.getContent());
        post.setDate(new Date());
        Blog blog = new Blog();
        blog.setId(postDto.getBlog().getId());
        post.setBlog(blog);
        return post;
    }

    private boolean sameDay(Date fechaPost, Date fechaActual) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(fechaPost).equals(fmt.format(fechaActual));
    }

}
