package com.purple.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private Date date;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties(value="comments")
    private Post post;
}
