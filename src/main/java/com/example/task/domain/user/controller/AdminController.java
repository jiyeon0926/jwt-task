package com.example.task.domain.user.controller;

import com.example.task.domain.user.dto.SignupReqDto;
import com.example.task.domain.user.dto.SignupResDto;
import com.example.task.domain.user.dto.UserResDto;
import com.example.task.domain.user.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    /**
     * 관리자 회원가입
     * @param signupReqDto
     * @return 회원가입 응답 DTO, 201 상태코드
     */
    @PostMapping("/signup")
    public ResponseEntity<SignupResDto> signup(@Valid @RequestBody SignupReqDto signupReqDto) {
        SignupResDto signupResDto = adminService.signup(
                signupReqDto.getEmail(),
                signupReqDto.getNickname(),
                signupReqDto.getPassword()
        );

        return new ResponseEntity<>(signupResDto, HttpStatus.CREATED);
    }

    /**
     * 사용자 전체 조회
     * - 고유 식별자(id), 이메일, 별명, 권한
     * @return 배열 형태의 사용자 조회 응답 DTO, 200 상태코드
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserResDto>> findAll() {
        List<UserResDto> findAll = adminService.findAll();

        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }
}