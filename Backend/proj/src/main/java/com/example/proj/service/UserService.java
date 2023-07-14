package com.example.proj.service;

import com.example.proj.dto.UserRegisterDto;
import com.example.proj.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public void save(UserRegisterDto userRegisterDto) {
        //1. dto -> entity 변환
        //2. repository의 save 메서드 호출
        //repository의 save메서드 호출
    }
}
