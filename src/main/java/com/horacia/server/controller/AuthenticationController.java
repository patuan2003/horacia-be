package com.horacia.server.controller;

import com.horacia.server.dto.request.AuthenticationRequest;
import com.horacia.server.dto.request.IntrospectRequest;
import com.horacia.server.dto.request.LogoutRequest;
import com.horacia.server.dto.response.AuthenticationResponse;
import com.horacia.server.dto.response.IntrospectResponse;
import com.horacia.server.dto.response.ResponseData;
import com.horacia.server.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenService;

    @PostMapping("/introspect")
    public ResponseData<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) {
        return ResponseData.<IntrospectResponse>builder()
                .status(200)
                .data(authenService.introspect(request))
                .build();
    }

    @PostMapping("/login")
    public ResponseData<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authentication) {
        var rs = authenService.authenticate(authentication);
        return ResponseData.<AuthenticationResponse>builder()
                .status(200)
                .message("login with jwt")
                .data(rs)
                .build();
    }

    @PostMapping("/logout")
    public ResponseData<Void> introspect(@RequestBody LogoutRequest req) {
        authenService.logout(req);
        return ResponseData.<Void>builder()
                .status(200)
                .message("logout successfully")
                .build();
    }

}
