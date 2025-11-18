package com.horacia.server.service.impl;

import com.horacia.server.constant.ErrorMessages;
import com.horacia.server.entity.Glass;
import com.horacia.server.exception.ResourceNotFoundException;
import com.horacia.server.repository.GlassRepo;
import com.horacia.server.service.GlassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GlassServiceImpl implements GlassService {

    private final GlassRepo glassRepo;

    @Override
    public Glass createGlass(Glass glass) {
        return glassRepo.save(glass);
    }

    @Override
    public Glass updateGlass(UUID id, Glass glass) {
        Glass existingGlass = glassRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.GLASS_NOT_FOUND, id)
                ));
        existingGlass.setName(glass.getName());

        return glassRepo.save(existingGlass);
    }

    @Override
    public List<Glass> getAllGlass() {
        return glassRepo.findAll();
    }

    @Override
    public Glass getGlassById(UUID id) {
        return glassRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format(ErrorMessages.GLASS_NOT_FOUND, id)
                ));
    }
}
