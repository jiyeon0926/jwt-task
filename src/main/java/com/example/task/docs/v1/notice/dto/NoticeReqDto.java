package com.example.task.docs.v1.notice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "공지사항 요청 DTO")
public class NoticeReqDto {

    @Schema(description = "제목", example = "이벤트 안내")
    private String title;

    @Schema(description = "내용", example = "5월 1일부터 5일까지 어린이날 이벤트를 진행합니다.")
    private String content;
}
