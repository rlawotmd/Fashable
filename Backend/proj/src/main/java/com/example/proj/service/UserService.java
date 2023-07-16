package com.example.proj.service;

import com.example.proj.dto.UserRegisterDto;
import com.example.proj.repo.UserRepo;
import com.example.proj.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.proj.user.User.toUser;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public void save(UserRegisterDto userRegisterDto) {
        //1. dto -> entity 변환
        //2. repository의 save 메서드 호출
        UserRegisterDto UserRegisterDto = null;
        User user = User.toUser(UserRegisterDto);
        userRepo.save(user);


        //repository의 save메서드 호출(조건. entity 객체를 넘겨줘야 함)
    }
}
