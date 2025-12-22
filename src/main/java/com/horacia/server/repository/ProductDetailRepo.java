package com.horacia.server.repository;


import com.horacia.server.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ProductDetailRepo extends JpaRepository<ProductDetails, UUID>,
        JpaSpecificationExecutor<ProductDetails> {
}
