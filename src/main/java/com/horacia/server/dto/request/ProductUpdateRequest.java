package com.horacia.server.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductUpdateRequest {

    private String name;
    private String modelCode;

    @Positive(message = "Diameter must be > 0")
    private BigDecimal diameter;

    @Positive(message = "Thickness must be > 0")
    private BigDecimal thickness;

    private UUID brandId;
    private UUID movementId;
    private UUID glassId;
    private UUID waterResistanceId;

}
