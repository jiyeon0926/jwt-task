package com.example.task.domain.user.controller;

import com.example.task.domain.user.dto.SignupReqDto;
import com.example.task.domain.user.dto.SignupResDto;
import com.example.task.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 사용자 회원가입
     * @param signupReqDto
     * @return 회원가입 응답 DTO, 201 상태코드
     */
    @PostMapping("/signup")
    public ResponseEntity<SignupResDto> signup(@Valid @RequestBody SignupReqDto signupReqDto) {
        SignupResDto signupResDto = userService.signup(
                signupReqDto.getEmail(),
                signupReqDto.getNickname(),
                signupReqDto.getPassword()
        );

        return new ResponseEntity<>(signupResDto, HttpStatus.CREATED);
    }
}
