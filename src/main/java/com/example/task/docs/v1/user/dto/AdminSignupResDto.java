package com.example.task.docs.v1.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "관리자 회원가입 응답 DTO")
public class AdminSignupResDto {

    @Schema(description = "고유 식별자", example = "1")
    private Long id;

    @Schema(description = "이메일", example = "admin1@naver.com")
    private String email;

    @Schema(description = "별명", example = "지연")
    private String nickname;

    @Schema(description = "권한", example = "ADMIN")
    private String role;
}
