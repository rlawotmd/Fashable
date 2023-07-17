package com.example.proj.service;

import com.example.proj.dto.UserLoginDto;
import com.example.proj.dto.UserRegisterDto;
import com.example.proj.repo.UserRepo;
import com.example.proj.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserLoginDto login(UserRegisterDto userRegisterDto) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        */
        Optional<User> byEmail = userRepo.findByEmail(UserRegisterDto.getEmail());
        if (byEmail.isPresent()){
            //조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            User user = byEmail.get();
            if (user.getPw().equals(UserRegisterDto.getPw())){
                //비밀번호 일치
                //entity -> dto 변환 후 리턴
                UserLoginDto dto = UserLoginDto.toUserLoginDto(user);
                return dto;
            } else{
                //비밀번호 불일치
                return null;
            }
        } else{
            //조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }
}
