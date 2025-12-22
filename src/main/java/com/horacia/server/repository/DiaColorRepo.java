package com.horacia.server.repository;

import com.horacia.server.entity.DiaColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiaColorRepo extends JpaRepository<DiaColor, UUID> {
}
