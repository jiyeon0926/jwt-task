package com.example.task.domain.user.service;

import com.example.task.domain.user.dto.AuthResDto;
import com.example.task.domain.user.repository.UserRepository;
import com.example.task.global.common.auth.util.AuthenticationScheme;
import com.example.task.global.common.auth.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public AuthResDto login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtProvider.generateAccessToken(authentication);

        return new AuthResDto(AuthenticationScheme.BEARER.getName(), accessToken);
    }
}
