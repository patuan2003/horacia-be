package com.horacia.server.service;

import com.horacia.server.dto.request.IntrospectRequest;
import com.horacia.server.dto.request.LogoutRequest;
import com.horacia.server.dto.response.IntrospectResponse;
import com.horacia.server.entity.User;
import com.nimbusds.jwt.SignedJWT;

public interface JwtService {

    String generateToken(User user);

    SignedJWT verifyToken(String token);

}
