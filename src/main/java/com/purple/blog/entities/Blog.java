package com.purple.blog.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@ToString
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String description;
    private String url;
    private String status;
    @ManyToOne()
    @JoinColumn(name = "autor_id")
    private Author author;
    @OneToMany( mappedBy = "blog")
    private List<Post> posts;
}
