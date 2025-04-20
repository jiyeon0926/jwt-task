package com.example.task.docs.v1.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "로그인 응답 DTO")
public class AuthResDto {

    @Schema(description = "토큰 인증 방식", example = "Bearer")
    private String tokenAuthScheme;

    @Schema(description = "Access 토큰", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMUBuYXZlci5jb20iLCJpYXQiOj")
    private String accessToken;
}
