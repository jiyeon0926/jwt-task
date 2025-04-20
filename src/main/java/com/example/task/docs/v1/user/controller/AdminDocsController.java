package com.example.task.docs.v1.user.controller;

import com.example.task.docs.v1.user.UserRole;
import com.example.task.docs.v1.user.dto.AdminSignupReqDto;
import com.example.task.docs.v1.user.dto.AdminSignupResDto;
import com.example.task.docs.v1.user.dto.UserResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admins")
@Tag(name = "Admin", description = "관리자 API")
public class AdminDocsController {

    @PostMapping("/signup")
    @Operation(summary = "관리자 회원가입")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "관리자 회원가입 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AdminSignupResDto.class)
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
    public ResponseEntity<AdminSignupResDto> signup(@RequestBody AdminSignupReqDto adminSignupReqDto) {
        AdminSignupResDto adminSignupResDto = new AdminSignupResDto();

        adminSignupResDto.setId(1L);
        adminSignupResDto.setEmail(adminSignupReqDto.getEmail());
        adminSignupResDto.setNickname(adminSignupReqDto.getNickname());
        adminSignupResDto.setRole(UserRole.ADMIN.name());

        return new ResponseEntity<>(adminSignupResDto, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    @Operation(summary = "사용자 전체 조회")
    @ApiResponse(
            responseCode = "200",
            description = "사용자 전체 조회",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = UserResDto.class)
                    )
            )
    )
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok("사용자 전체 조회");
    }
}
