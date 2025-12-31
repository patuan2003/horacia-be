package com.horacia.server.service;

import com.horacia.server.dto.request.IntrospectRequest;
import com.horacia.server.dto.response.IntrospectResponse;
import com.horacia.server.entity.User;

public interface JwtService {

    String generateToken(User user);

    boolean verifyToken(IntrospectRequest req);

}
