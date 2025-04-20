package com.example.task.domain.notice.controller;

import com.example.task.domain.notice.dto.NoticeReqDto;
import com.example.task.domain.notice.dto.NoticeResDto;
import com.example.task.domain.notice.service.AdminNoticeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins/notices")
@RequiredArgsConstructor
public class AdminNoticeController {

    private final AdminNoticeService adminNoticeService;

    /**
     * 공지사항 작성
     * @param noticeReqDto
     * @param request
     * @return 공지사항 응답 DTO, 201 상태코드
     */
    @PostMapping
    public ResponseEntity<NoticeResDto> createNotice(@Valid @RequestBody NoticeReqDto noticeReqDto, HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        NoticeResDto noticeResDto = adminNoticeService.createNotice(noticeReqDto.getTitle(), noticeReqDto.getContent(), bearerToken);

        return new ResponseEntity<>(noticeResDto, HttpStatus.CREATED);
    }
}
