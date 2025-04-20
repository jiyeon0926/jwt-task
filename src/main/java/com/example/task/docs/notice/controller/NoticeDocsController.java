package com.example.task.docs.notice.controller;

import com.example.task.docs.notice.dto.NoticeResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notices")
@Tag(name = "Notice", description = "공지사항 API")
public class NoticeDocsController {

    @GetMapping
    @Operation(summary = "공지사항 전체 조회")
    @ApiResponse(
            responseCode = "200",
            description = "공지사항 전체 조회",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = NoticeResDto.class)
                    )
            )
    )
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok("공지사항 전체 조회");
    }
}
