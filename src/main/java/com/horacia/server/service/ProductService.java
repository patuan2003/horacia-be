package com.horacia.server.service;

import com.horacia.server.dto.request.ProductRequest;
import com.horacia.server.dto.response.ProductResponse;
import com.horacia.server.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

}

