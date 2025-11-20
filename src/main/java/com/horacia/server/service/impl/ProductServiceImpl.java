package com.horacia.server.service.impl;

import com.horacia.server.constant.ErrorMessages;
import com.horacia.server.dto.request.ProductCreateRequest;
import com.horacia.server.dto.request.ProductUpdateRequest;
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
    public ProductResponse createProduct(ProductCreateRequest request) {

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

    @Override
    public ProductResponse getProductById(UUID id) {
        Product exsingProduct = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.PRODUCT_NOT_FOUND, id)
                ));

        return productMapper.toDTO(exsingProduct);
    }

    @Override
    public ProductResponse updateProduct(UUID id, ProductUpdateRequest request) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.PRODUCT_NOT_FOUND, id)
                ));

        if (request.getName() != null && !request.getName().isBlank()) {
            existingProduct.setName(request.getName());
        }

        if (request.getModelCode() != null && !request.getModelCode().isBlank()) {
            existingProduct.setModelCode(request.getModelCode());
        }

        if (request.getDiameter() != null) {
            existingProduct.setDiameter(request.getDiameter());
        }

        if (request.getThickness() != null) {
            existingProduct.setThickness(request.getThickness());
        }

        if (request.getBrandId() != null) {
            Brand brand = brandService.getBrandById(request.getBrandId());
            existingProduct.setBrand(brand);
        }

        if (request.getMovementId() != null) {
            Movement movement = movementService.getMovementById(request.getMovementId());
            existingProduct.setMovement(movement);
        }

        if (request.getGlassId() != null) {
            Glass glass = glassService.getGlassById(request.getGlassId());
            existingProduct.setGlass(glass);
        }

        if (request.getWaterResistanceId() != null) {
            WaterResistance wr = waterResistanceService.getWaterResistanceById(request.getWaterResistanceId());
            existingProduct.setWaterResistance(wr);
        }

        productRepo.save(existingProduct);

        return productMapper.toDTO(existingProduct);
    }

    @Override
    public ProductResponse deleteProduct(UUID id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.PRODUCT_NOT_FOUND, id)
                ));

        product.setStatus("DELETED");
        return productMapper.toDTO(productRepo.save(product));
    }

}
