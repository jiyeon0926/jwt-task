package com.example.task.docs.v1.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "사용자 조회 응답 DTO")
public class UserResDto {

    @Schema(description = "고유 식별자", example = "1")
    private Long id;

    @Schema(description = "이메일", example = "user1@naver.com")
    private String email;

    @Schema(description = "별명", example = "delay")
    private String nickname;

    @Schema(description = "권한", example = "USER")
    private String role;
}
