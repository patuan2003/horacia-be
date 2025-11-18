package com.horacia.server.service.impl;

import com.horacia.server.constant.ErrorMessages;
import com.horacia.server.dto.request.ProductRequest;
import com.horacia.server.dto.response.ProductResponse;
import com.horacia.server.entity.*;
import com.horacia.server.exception.ResourceNotFoundException;
import com.horacia.server.mapper.ProductMapper;
import com.horacia.server.repository.ProductRepo;
import com.horacia.server.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
    private final BrandService brandService;
    private final GlassService glassService;
    private final MovementService movementService;
    private final WaterResistanceService waterResistanceService;

    @Override
    public ProductResponse createProduct(ProductRequest request) {

        Brand brand = brandService.getBrandById(request.getBrandId());
        Glass glass = glassService.getGlassById(request.getGlassId());
        Movement movement = movementService.getMovementById(request.getMovementId());
        WaterResistance waterResistance = waterResistanceService.
                getWaterResistanceById(request.getWaterResistanceId());

        Product product = Product.builder()
                .name(request.getName())
                .modelCode(request.getModelCode())
                .diameter(request.getDiameter())
                .thickness(request.getThickness())
                .brand(brand)
                .movement(movement)
                .glass(glass)
                .waterResistance(waterResistance)
                .build();

        return productMapper.toDTO(productRepo.save(product));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }

}
