package com.horacia.server.service;

import com.horacia.server.entity.Glass;
import com.horacia.server.entity.WaterResistance;

import java.util.List;
import java.util.UUID;

public interface WaterResistanceService {

    WaterResistance createWaterResistance(WaterResistance waterResistance);

    WaterResistance updateWaterResistance(UUID id, WaterResistance waterResistance);

    List<WaterResistance> getAllWaterResistance();

    WaterResistance getWaterResistanceById(UUID id);

}
