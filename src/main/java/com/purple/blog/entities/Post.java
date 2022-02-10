package com.purple.blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "autores")
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
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "blog_id")
    private Blog blog;
}
