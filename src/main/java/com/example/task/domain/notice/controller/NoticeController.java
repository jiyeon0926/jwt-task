package com.example.task.domain.notice.controller;

import com.example.task.domain.notice.dto.NoticeResDto;
import com.example.task.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    /**
     * 공지사항 전체 조회
     * @return 공지사항 응답 DTO, 200 상태코드
     */
    @GetMapping
    public ResponseEntity<List<NoticeResDto>> findAll() {
        List<NoticeResDto> findAll = noticeService.findAll();

        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }
}
