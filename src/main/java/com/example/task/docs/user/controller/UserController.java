package com.example.task.docs.user.controller;

import com.example.task.docs.user.UserRole;
import com.example.task.docs.user.dto.UserSignupReqDto;
import com.example.task.docs.user.dto.UserSignupResDto;
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
@RequestMapping("/users")
@Tag(name = "User", description = "사용자 API")
public class UserController {

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "회원가입 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserSignupResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "이메일 또는 별명이 중복일 경우",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"error\": {\n" +
                                            "    \"code\": \"USER_ALREADY_EXISTS\",\n" +
                                            "    \"message\": \"이미 가입된 사용자입니다.\"\n" +
                                            "  }\n" +
                                            "}"
                            )
                    )
            )
    })
    public ResponseEntity<UserSignupResDto> signup(@RequestBody UserSignupReqDto userSignupReqDto) {
        UserSignupResDto userSignupResDto = new UserSignupResDto();

        userSignupResDto.setId(1L);
        userSignupResDto.setEmail(userSignupReqDto.getEmail());
        userSignupResDto.setNickname(userSignupReqDto.getNickname());
        userSignupResDto.setRole(UserRole.USER.name());

        return new ResponseEntity<>(userSignupResDto, HttpStatus.CREATED);
    }
}
