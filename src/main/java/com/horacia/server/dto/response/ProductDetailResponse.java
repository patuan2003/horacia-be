package com.horacia.server.dto.response;

import com.horacia.server.util.Status;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class ProductDetailResponse implements Serializable {

    private UUID id;
    private String sku;
    private BigDecimal price;
    private Integer stock;
    private UUID productId;
    private String productName;
    private UUID strapId;
    private String strapName;

    private UUID diaColorId;
    private String diaColorName;
    private Status status;
    private List<ImageResponse> images;

}
