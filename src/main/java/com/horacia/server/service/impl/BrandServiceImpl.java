package com.horacia.server.service.impl;

import com.horacia.server.constant.ErrorMessages;
import com.horacia.server.entity.Brand;
import com.horacia.server.exception.ResourceNotFoundException;
import com.horacia.server.repository.BrandRepo;
import com.horacia.server.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepo brandRepo;

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepo.save(brand);
    }

    @Override
    public Brand updateBrand(UUID id, Brand brand) {
        Brand existingBrand = brandRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.BRAND_NOT_FOUND, id)
                ));

        existingBrand.setName(brand.getName());
        existingBrand.setStatus(brand.getStatus());
        existingBrand.setUpdatedBy(brand.getUpdatedBy());

        return brandRepo.save(existingBrand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepo.findAll();
    }

    @Override
    public Brand getBrandById(UUID id) {
        return brandRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.BRAND_NOT_FOUND, id)
                ));
    }
}
