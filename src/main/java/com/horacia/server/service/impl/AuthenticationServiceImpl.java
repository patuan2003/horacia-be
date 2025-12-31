package com.horacia.server.service.impl;

import com.horacia.server.constant.ErrorCode;
import com.horacia.server.dto.request.AuthenticationRequest;
import com.horacia.server.dto.request.IntrospectRequest;
import com.horacia.server.dto.response.AuthenticationResponse;
import com.horacia.server.dto.response.IntrospectResponse;
import com.horacia.server.entity.User;
import com.horacia.server.exception.AppException;
import com.horacia.server.repository.UserRepo;
import com.horacia.server.service.AuthenticationService;
import com.horacia.server.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public IntrospectResponse introspect(IntrospectRequest req) {
        return IntrospectResponse.builder()
                .valid(jwtService.verifyToken(req))
                .build();
    }

    @Transactional
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest req) {

        User user = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        boolean authenticated = passwordEncoder.matches(
                req.getPassword(),
                user.getPassword()
        );

        if (!authenticated) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }

        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(user))
                .authenticated(true)
                .build();
    }

}
