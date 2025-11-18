package com.horacia.server.service.impl;

import com.horacia.server.constant.ErrorMessages;
import com.horacia.server.entity.Movement;
import com.horacia.server.exception.ResourceNotFoundException;
import com.horacia.server.repository.MovementRepo;
import com.horacia.server.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

    private final MovementRepo movementRepo;

    @Override
    public Movement createMovement(Movement movement) {
        return movementRepo.save(movement);
    }

    @Override
    public Movement updateMovement(UUID id, Movement movement) {
        Movement existingMovement = movementRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.MOVEMENT_NOT_FOUND, id)
                ));

        existingMovement.setName(movement.getName());

        return movementRepo.save(existingMovement);
    }

    @Override
    public List<Movement> getAllMovement() {
        return movementRepo.findAll();
    }

    @Override
    public Movement getMovementById(UUID id) {
        return movementRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.MOVEMENT_NOT_FOUND, id)
                ));
    }
}
