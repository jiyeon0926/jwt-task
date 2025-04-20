package com.example.task.domain.user.service;

import com.example.task.domain.user.dto.SignupResDto;
import com.example.task.domain.user.entity.User;
import com.example.task.domain.user.repository.UserRepository;
import com.example.task.global.common.constant.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public SignupResDto signup(String email, String nickname, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(email, nickname, encodedPassword, UserRole.ADMIN.name());
        User savedUser = userRepository.save(user);

        return new SignupResDto(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getNickname(),
                savedUser.getRole().name()
        );
    }
}
