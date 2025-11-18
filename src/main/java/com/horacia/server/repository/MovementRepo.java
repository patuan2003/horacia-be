package com.horacia.server.repository;

import com.horacia.server.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovementRepo extends JpaRepository<Movement, UUID> {
}
