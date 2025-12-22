package com.horacia.server.repository;

import com.horacia.server.entity.Strap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StrapRepo extends JpaRepository<Strap, UUID>  {
}
