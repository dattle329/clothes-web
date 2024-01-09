package com.example.grabfoodapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String username;
}

