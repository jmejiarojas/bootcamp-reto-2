package com.purple.blog.repositories;

import com.purple.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByStatusEquals(String status);
    List<Post> findByBlog_Id(Long blogId);
}