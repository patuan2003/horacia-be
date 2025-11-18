package com.horacia.server.service.impl;

import com.horacia.server.constant.ErrorMessages;
import com.horacia.server.entity.WaterResistance;
import com.horacia.server.exception.ResourceNotFoundException;
import com.horacia.server.repository.WaterResistanceRepo;
import com.horacia.server.service.WaterResistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WaterResistanceServiceImpl implements WaterResistanceService {

    private final WaterResistanceRepo waterResistanceRepo;

    @Override
    public WaterResistance createWaterResistance(WaterResistance waterResistance) {
        return waterResistanceRepo.save(waterResistance);
    }

    @Override
    public WaterResistance updateWaterResistance(UUID id, WaterResistance waterResistance) {
        WaterResistance existingWaterResistance = waterResistanceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.WATER_RESISTANCE_NOT_FOUND, id)
                ));

        existingWaterResistance.setLevel(waterResistance.getLevel());

        return waterResistanceRepo.save(existingWaterResistance);
    }

    @Override
    public List<WaterResistance> getAllWaterResistance() {
        return waterResistanceRepo.findAll();
    }

    @Override
    public WaterResistance getWaterResistanceById(UUID id) {
        return waterResistanceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.WATER_RESISTANCE_NOT_FOUND, id)
                ));
    }
}
