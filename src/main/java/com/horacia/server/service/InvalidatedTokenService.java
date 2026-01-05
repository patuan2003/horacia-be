package com.horacia.server.service;

import com.horacia.server.entity.InvalidatedToken;

public interface InvalidatedTokenService {

    InvalidatedToken save(InvalidatedToken invalidatedToken);

    boolean existsById(String id);

}
