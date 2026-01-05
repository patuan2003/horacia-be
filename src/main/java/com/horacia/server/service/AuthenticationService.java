package com.horacia.server.service;

import com.horacia.server.dto.request.AuthenticationRequest;
import com.horacia.server.dto.request.IntrospectRequest;
import com.horacia.server.dto.request.LogoutRequest;
import com.horacia.server.dto.response.AuthenticationResponse;
import com.horacia.server.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {

    IntrospectResponse introspect(IntrospectRequest introspectRequest);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void logout(LogoutRequest request) throws ParseException;

}
