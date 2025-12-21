package com.horacia.server.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class ProductDetailFilterRequest {

    private UUID productId;
    private UUID brandId;
    private UUID movementId;
    private UUID glassId;
    private UUID waterResistanceId;
    private UUID strapId;
    private UUID diaColorId;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String productName;
    private String strapName;
    private String diaColorName;
    private String sort;

}
