package com.horacia.server.service.impl;

import com.horacia.server.dto.request.ProductDetailFilterRequest;
import com.horacia.server.dto.response.PageResponse;
import com.horacia.server.dto.response.ProductDetailResponse;
import com.horacia.server.entity.ProductDetails;
import com.horacia.server.mapper.ProductDetailMapper;
import com.horacia.server.repository.ProductDetailRepo;
import com.horacia.server.service.ProductDetailService;
import com.horacia.server.specification.ProductDetailSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepo productDetailRepo;
    private final ProductDetailMapper productDetailMapper;

    @Transactional
    @Override
    public PageResponse<ProductDetailResponse> getAllProductDetail(int pageNo, int pageSize,
                                                                   ProductDetailFilterRequest req) {
        List<Sort.Order> orders = new ArrayList<>();

        if (StringUtils.hasLength(req.getSort())) {
            String[] sortParams = req.getSort().split(",");
            for (String s : sortParams) {
                String[] parts = s.split(":");
                if (parts.length == 2) {
                    String field = parts[0].trim();
                    String direction = parts[1].trim();

                    orders.add(
                            direction.equalsIgnoreCase("desc")
                                    ? Sort.Order.desc(field)
                                    : Sort.Order.asc(field)
                    );
                }
            }
        }

        Pageable pageable = PageRequest.of(pageNo == 0 ? 0 : pageNo - 1,
                pageSize,
                orders.isEmpty() ? Sort.unsorted() : Sort.by(orders));

        Page<ProductDetails> page = productDetailRepo.findAll(
                ProductDetailSpecification.filter(req),
                pageable
        );

        return PageResponse.<ProductDetailResponse>builder()
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .items(page.getContent().stream()
                        .map(productDetailMapper::toDTO)
                        .toList())
                .build();
    }

}

