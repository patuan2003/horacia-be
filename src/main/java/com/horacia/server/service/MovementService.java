package com.horacia.server.service;

import com.horacia.server.entity.Glass;
import com.horacia.server.entity.Movement;

import java.util.List;
import java.util.UUID;

public interface MovementService {

    Movement createMovement(Movement movement);

    Movement updateMovement(UUID id, Movement movement);

    List<Movement> getAllMovement();

    Movement getMovementById(UUID id);

}
