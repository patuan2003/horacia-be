package com.horacia.server.service.impl;

import com.horacia.server.entity.InvalidatedToken;
import com.horacia.server.repository.InvalidatedTokenRepo;
import com.horacia.server.service.InvalidatedTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvalidatedTokenServiceImpl implements InvalidatedTokenService {

    private final InvalidatedTokenRepo invalidatedTokenRepo;

    @Override
    public InvalidatedToken save(InvalidatedToken invalidatedToken) {
        return invalidatedTokenRepo.save(InvalidatedToken.builder()
                .id(invalidatedToken.getId())
                .expiredAt(invalidatedToken.getExpiredAt())
                .build());
    }

    @Override
    public boolean existsById(String id) {
        return invalidatedTokenRepo.existsById(id);
    }

}
