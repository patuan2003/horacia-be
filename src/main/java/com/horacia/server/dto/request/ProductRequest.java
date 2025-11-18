package com.horacia.server.dto.request;

import com.horacia.server.constant.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ProductRequest {

    @NotBlank(message = ErrorMessages.PRODUCT_MODEL_CODE_NOT_EMPTY)
    private String name;

    @NotBlank(message = ErrorMessages.PRODUCT_MODEL_CODE_NOT_EMPTY)
    private String modelCode;

    @NotNull(message = ErrorMessages.PRODUCT_DIAMETER_REQUIRED)
    @Positive(message = "Diameter must be greater than 0")
    private BigDecimal diameter;

    @NotNull(message = ErrorMessages.PRODUCT_THICKNESS_REQUIRED)
    @Positive(message = "Thickness must be greater than 0")
    private BigDecimal thickness;

    @NotNull(message = ErrorMessages.BRAND_ID_REQUIRED)
    private UUID brandId;

    @NotNull(message = ErrorMessages.MOVEMENT_ID_REQUIRED)
    private UUID movementId;

    @NotNull(message = ErrorMessages.GLASS_ID_REQUIRED)
    private UUID glassId;

    @NotNull(message = ErrorMessages.WATER_RESISTANCE_ID_REQUIRED)
    private UUID waterResistanceId;

}