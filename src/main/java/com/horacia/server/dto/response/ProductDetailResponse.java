package com.horacia.server.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class ProductDetailResponse implements Serializable {

    private UUID id;
    private String sku;
    private BigDecimal price;
    private Integer stock;

    private UUID strapId;
    private String strapName;

    private UUID diaColorId;
    private String diaColorName;

    private UUID productId;
    private String productName;

}
