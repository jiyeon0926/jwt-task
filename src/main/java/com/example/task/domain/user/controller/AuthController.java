package com.example.task.domain.user.controller;

import com.example.task.domain.user.dto.AuthReqDto;
import com.example.task.domain.user.dto.AuthResDto;
import com.example.task.domain.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * 로그인
     * @param authReqDto
     * @return Access 토큰 발급, 200 상태코드
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResDto> login(@Valid @RequestBody AuthReqDto authReqDto) {
        AuthResDto authResDto = authService.login(authReqDto.getEmail(), authReqDto.getPassword());

        return new ResponseEntity<>(authResDto, HttpStatus.OK);
    }
}
