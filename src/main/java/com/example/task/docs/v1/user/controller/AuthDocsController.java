package com.example.task.docs.v1.user.controller;

import com.example.task.docs.v1.user.dto.AuthReqDto;
import com.example.task.docs.v1.user.dto.AuthResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Auth", description = "로그인 API")
public class AuthDocsController {

    @PostMapping("/login")
    @Operation(summary = "로그인")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "로그인 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 요청일 경우",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"error\": {\n" +
                                            "    \"code\": \"INVALID_CREDENTIALS\",\n" +
                                            "    \"message\": \"이메일 또는 비밀번호가 일치하지 않습니다.\"\n" +
                                            "  }\n" +
                                            "}"
                            )
                    )
            )
    })
    public ResponseEntity<AuthResDto> login(@RequestBody AuthReqDto authReqDto) {
        AuthResDto authResDto = new AuthResDto();

        authResDto.setTokenAuthScheme("Bearer");
        authResDto.setAccessToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMUBuYXZlci5jb20iLCJpYXQiOj");

        return new ResponseEntity<>(authResDto, HttpStatus.OK);
    }
}
