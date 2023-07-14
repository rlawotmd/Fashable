package com.example.proj.controller;

import com.example.proj.dto.UserRegisterDto;
import com.example.proj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    //생성자 주입
    private final UserService userService;

    //회원가입 페이지 출력 요청
    @GetMapping("/user/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/user/save")
    public String save(@ModelAttribute UserRegisterDto userRegisterDto){
        System.out.println("UserController.save");
        System.out.println("userRegisterDto = " + userRegisterDto);
        userService.save(userRegisterDto);
        return "index";
    }

}