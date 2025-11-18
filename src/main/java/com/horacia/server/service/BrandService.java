package com.horacia.server.service;

import com.horacia.server.entity.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    Brand createBrand(Brand brand);

    Brand updateBrand(UUID id, Brand brand);

    List<Brand> getAllBrands();

    Brand getBrandById(UUID id);
}
