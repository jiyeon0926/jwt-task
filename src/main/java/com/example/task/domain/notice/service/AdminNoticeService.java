package com.example.task.domain.notice.service;

import com.example.task.domain.notice.dto.NoticeResDto;
import com.example.task.domain.notice.entity.Notice;
import com.example.task.domain.notice.repository.NoticeRepository;
import com.example.task.domain.user.entity.User;
import com.example.task.domain.user.service.UserService;
import com.example.task.global.common.auth.util.AuthenticationScheme;
import com.example.task.global.common.auth.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminNoticeService {

    private final NoticeRepository noticeRepository;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Transactional
    public NoticeResDto createNotice(String title, String content, String bearerToken) {
        String headerPrefix = AuthenticationScheme.generateType(AuthenticationScheme.BEARER);
        String accessToken = bearerToken.substring(headerPrefix.length());

        String email = jwtProvider.getUsername(accessToken);
        User user = userService.findUserByEmail(email);

        Notice notice = new Notice(user, title, content);
        Notice savedNotice = noticeRepository.save(notice);

        return new NoticeResDto(
                savedNotice.getId(),
                savedNotice.getTitle(),
                savedNotice.getContent(),
                savedNotice.getCreatedAt(),
                savedNotice.getUpdatedAt()
        );
    }
}
