package com.purple.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    private Date date;
    private String status;
    private String content;
    @ManyToOne()
    @JoinColumn(name = "blog_id")
    @JsonIgnoreProperties(value="posts")
    private Blog blog;
    @OneToMany( mappedBy = "post")
    private List<Comment> comments;
}
