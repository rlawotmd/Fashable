package com.example.proj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserRegisterDto {
    private String email;
    private String pw;
    private String name;
}
