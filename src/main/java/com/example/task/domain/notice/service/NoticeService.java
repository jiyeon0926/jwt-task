package com.example.task.domain.notice.service;

import com.example.task.domain.notice.dto.NoticeResDto;
import com.example.task.domain.notice.entity.Notice;
import com.example.task.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<NoticeResDto> findAll() {
        List<Notice> notices = noticeRepository.findAll();

        return notices.stream()
                .map(notice -> new NoticeResDto(
                        notice.getId(),
                        notice.getTitle(),
                        notice.getContent(),
                        notice.getCreatedAt(),
                        notice.getUpdatedAt()))
                .collect(Collectors.toList());
    }
}
