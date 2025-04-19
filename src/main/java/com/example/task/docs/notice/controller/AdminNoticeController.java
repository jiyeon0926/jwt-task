package com.example.task.docs.notice.controller;

import com.example.task.docs.notice.dto.NoticeReqDto;
import com.example.task.docs.notice.dto.NoticeResDto;
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

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admins/notices")
@Tag(name = "Admin - Notice", description = "관리자 권한 공지사항 API")
public class AdminNoticeController {

    @PostMapping
    @Operation(summary = "공지사항 작성")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "공지사항 작성 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NoticeResDto.class)
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
                                            "    \"code\": \"NOTICE_INVALID_INPUT\",\n" +
                                            "    \"message\": \"유효하지 않은 입력입니다.\"\n" +
                                            "  }\n" +
                                            "}"
                            )
                    )
            )
    })
    public ResponseEntity<NoticeResDto> createNotice(@RequestBody NoticeReqDto noticeReqDto) {
        NoticeResDto noticeResDto = new NoticeResDto();

        noticeResDto.setId(1L);
        noticeResDto.setTitle(noticeReqDto.getTitle());
        noticeResDto.setContent(noticeReqDto.getContent());

        LocalDateTime now = LocalDateTime.now();
        noticeResDto.setCreatedAt(now);
        noticeResDto.setUpdatedAt(now);

        return new ResponseEntity<>(noticeResDto, HttpStatus.CREATED);
    }
}
