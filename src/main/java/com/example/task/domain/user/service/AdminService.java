package com.example.task.domain.user.service;

import com.example.task.domain.user.dto.SignupResDto;
import com.example.task.domain.user.dto.UserResDto;
import com.example.task.domain.user.entity.User;
import com.example.task.domain.user.repository.UserRepository;
import com.example.task.global.common.constant.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
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

    @Transactional(readOnly = true)
    public List<UserResDto> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResDto(
                        user.getId(),
                        user.getEmail(),
                        user.getNickname(),
                        user.getRole().name()))
                .collect(Collectors.toList());
    }
}
