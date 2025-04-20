package com.example.task.domain.user.service;

import com.example.task.domain.user.dto.SignupResDto;
import com.example.task.domain.user.entity.User;
import com.example.task.domain.user.repository.UserRepository;
import com.example.task.global.common.constant.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public SignupResDto signup(String email, String nickname, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(email, nickname, encodedPassword, UserRole.USER.name());
        User savedUser = userRepository.save(user);

        return new SignupResDto(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getNickname(),
                savedUser.getRole().name()
        );
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."));
    }
}
