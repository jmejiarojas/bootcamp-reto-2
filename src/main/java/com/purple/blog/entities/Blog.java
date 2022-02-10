package com.purple.blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "autores")
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String description;
    private String url;
    private String status;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "autor_id")
    private Author author;
}
