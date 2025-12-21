package com.horacia.server.mapper;

import com.horacia.server.dto.response.ProductDetailResponse;
import com.horacia.server.entity.ProductDetails;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMapper {
    public ProductDetailResponse toDTO(ProductDetails details){
        return ProductDetailResponse.builder()
                .id(details.getId())
                .sku(details.getSku())
                .price(details.getPrice())
                .stock(details.getStock())
                .productId(details.getProduct().getId())
                .productName(details.getProduct().getName())
                .strapId(details.getStrap().getId())
                .strapName(details.getStrap().getName())
                .diaColorId(details.getDiaColor().getId())
                .diaColorName(details.getDiaColor().getName())
                .status(details.getStatus())
                .build();
    }

}
