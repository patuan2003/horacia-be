package com.horacia.server.repository;

import com.horacia.server.entity.Glass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GlassRepo extends JpaRepository<Glass, UUID> {
}
