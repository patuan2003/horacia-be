package com.horacia.server.service.impl;

import com.horacia.server.dto.response.PageResponse;
import com.horacia.server.dto.response.ProductDetailResponse;
import com.horacia.server.dto.response.ProductResponse;
import com.horacia.server.entity.ProductDetail;
import com.horacia.server.mapper.ProductDetailMapper;
import com.horacia.server.repository.ProductDetailRepo;
import com.horacia.server.service.ProductDetailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepo productDetailRepo;
    private final ProductDetailMapper productDetailMapper;

    @Transactional
    @Override
    public PageResponse<ProductDetailResponse> getAllProductDetails(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<ProductDetail> result = productDetailRepo.findAll(pageable);

        return PageResponse.<ProductDetailResponse>builder()
                .items(result.getContent().stream()
                        .map(productDetailMapper::toDTO)
                        .toList())
                .pageNo(result.getNumber())
                .pageSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalItems(result.getTotalElements())
                .build();
    }
}
