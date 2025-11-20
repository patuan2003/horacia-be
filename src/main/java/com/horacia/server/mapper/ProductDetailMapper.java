package com.horacia.server.mapper;

import com.horacia.server.dto.response.ProductDetailResponse;
import com.horacia.server.entity.ProductDetail;
import com.horacia.server.repository.ProductDetailRepo;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMapper {

    public ProductDetailResponse toDTO(ProductDetail detail) {
        return ProductDetailResponse.builder()
                .id(detail.getId())
                .sku(detail.getSku())
                .price(detail.getPrice())
                .stock(detail.getStock())
                .productId(detail.getProduct().getId())
                .productName(detail.getProduct().getName())
                .strapId(detail.getStrap().getId())
                .strapName(detail.getStrap().getName())
                .diaColorId(detail.getDiaColor().getId())
                .diaColorName(detail.getDiaColor().getName())
                .build();
    }

}
