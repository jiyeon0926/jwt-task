package com.example.task.docs.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "회원가입 요청 DTO")
public class UserSignupReqDto {

    @Schema(description = "이메일", example = "user1@naver.com")
    private String email;

    @Schema(description = "별명", example = "delay")
    private String nickname;

    @Schema(description = "비밀번호", example = "User123@")
    private String password;
}
