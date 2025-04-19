package com.example.task.docs.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "로그인 요청 DTO")
public class AuthReqDto {

    @Schema(description = "이메일", example = "user1@naver.com")
    private String email;

    @Schema(description = "비밀번호", example = "User123@")
    private String password;
}
