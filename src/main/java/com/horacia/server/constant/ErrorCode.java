package com.horacia.server.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(1001, "User does not exist"),
    USER_EXISTED(1002, "User already exist"),
    INVALID_CREDENTIALS(1003, "Username or password is incorrect"),
    UNAUTHORIZED(1004, "Unauthorized"),
    FORBIDDEN(1005, "Access denied"),
    ;

    private final int code;
    private final String message;


}
