package com.purple.blog.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuthorRequest {
    private String name;
    private String email;
    private String phone;
    private Date birthDate;
}
