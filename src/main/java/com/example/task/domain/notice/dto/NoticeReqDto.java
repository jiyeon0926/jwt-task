package com.example.task.domain.notice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class NoticeReqDto {

    @NotBlank(message = "제목은 필수 항목 입니다.")
    @Size(max = 50)
    private String title;

    @NotBlank(message = "내용은 필수 항목 입니다.")
    private String content;
}
