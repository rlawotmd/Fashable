package com.example.proj.dto;

import com.example.proj.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserLoginDto {
    private String email;
    private String pw;

    public static UserLoginDto toUserLoginDto(User user) {
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setEmail(user.getEmail());
        userLoginDto.setPw(user.getPw());
        return userLoginDto;
    }
}
