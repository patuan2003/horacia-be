package com.horacia.server.repository;

import com.horacia.server.entity.WaterResistance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WaterResistanceRepo extends JpaRepository<WaterResistance, UUID> {
}
