package com.horacia.server.service;

import com.horacia.server.dto.request.ProductCreateRequest;
import com.horacia.server.dto.request.ProductUpdateRequest;
import com.horacia.server.dto.response.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse createProduct(ProductCreateRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(UUID id);

    ProductResponse updateProduct(UUID id, ProductUpdateRequest request);

    ProductResponse deleteProduct(UUID id);

}

