package com.horacia.server.repository;

import com.horacia.server.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepo extends JpaRepository<Brand, UUID> {
}
