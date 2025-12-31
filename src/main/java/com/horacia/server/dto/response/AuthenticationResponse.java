package com.horacia.server.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
public class AuthenticationResponse {

    private String token;
    private boolean authenticated;

}
