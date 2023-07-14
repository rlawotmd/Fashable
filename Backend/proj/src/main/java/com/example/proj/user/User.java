package com.example.proj.user;

import com.example.proj.dto.UserRegisterDto;
import com.example.proj.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id
    @Column(nullable = false) // DB값으로 null값 들어가지 않도록 하는 어노테이션.
    private String email;
    @Column(nullable = false)
    private String nickName;
    @Column(nullable = false)
    private String pw;

    public User(UserRegisterDto userRegisterDto) {
        this(userRegisterDto.getEmail(), userRegisterDto.getNickName(), userRegisterDto.getPw());
    }

    public User(String email, String nickName, String pw) {
        this.email = email;
        this.nickName = nickName;

        this.pw = pw; // 나중에 해시 함수 돌려서 해시 값 가지고 있도록 변경.
    }
}
