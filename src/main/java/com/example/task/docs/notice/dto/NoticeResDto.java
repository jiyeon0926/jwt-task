package com.example.task.docs.notice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "공지사항 응답 DTO")
public class NoticeResDto {

    @Schema(description = "고유 식별자", example = "1")
    private Long id;

    @Schema(description = "제목", example = "이벤트 안내")
    private String title;

    @Schema(description = "내용", example = "5월 1일부터 5일까지 어린이날 이벤트를 진행합니다.")
    private String content;

    @Schema(description = "생성 일자", example = "2025-04-20T05:19:51.8820138")
    private LocalDateTime createdAt;

    @Schema(description = "수정 일자", example = "2025-04-20T05:19:51.8820138")
    private LocalDateTime updatedAt;
}
