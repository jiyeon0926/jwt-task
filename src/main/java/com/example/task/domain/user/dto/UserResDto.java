package com.example.task.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResDto {

    private final Long id;
    private final String email;
    private final String nickname;
    private final String role;
}
