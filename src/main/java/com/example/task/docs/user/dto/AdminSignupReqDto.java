package com.example.task.docs.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "관리자 회원가입 요청 DTO")
public class AdminSignupReqDto {

    @Schema(description = "이메일", example = "admin1@naver.com")
    private String email;

    @Schema(description = "별명", example = "지연")
    private String nickname;

    @Schema(description = "비밀번호", example = "Admin123@")
    private String password;
}
