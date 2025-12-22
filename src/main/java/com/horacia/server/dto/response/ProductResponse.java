package com.horacia.server.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.horacia.server.util.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable {

    private UUID id;
    private String modelCode;
    private String name;
    private BigDecimal diameter;
    private BigDecimal thickness;
    private Status status;

    private BrandResponse brand;
    private MovementResponse movement;
    private GlassResponse glass;
    private WaterResistanceResponse waterResistance;

}
