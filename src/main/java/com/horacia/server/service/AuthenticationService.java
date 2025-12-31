package com.horacia.server.service;

import com.horacia.server.dto.request.AuthenticationRequest;
import com.horacia.server.dto.request.IntrospectRequest;
import com.horacia.server.dto.response.AuthenticationResponse;
import com.horacia.server.dto.response.IntrospectResponse;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect(IntrospectRequest request);

}
