package com.horacia.server.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
@Builder
public class ProductDetailRequest {

    private UUID productId;
    private String sku;
    private BigDecimal price;
    private Integer stock;
    private UUID strapId;
    private UUID diaColorId;

}
