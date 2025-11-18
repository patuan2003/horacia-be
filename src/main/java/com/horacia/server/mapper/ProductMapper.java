package com.horacia.server.mapper;

import com.horacia.server.dto.response.*;
import com.horacia.server.entity.*;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class ProductMapper {

    public ProductResponse toDTO(Product p) {
        if (p == null) {
            return null;
        }

        return ProductResponse.builder()
                .id(p.getId())
                .modelCode(p.getModelCode())
                .name(p.getName())
                .diameter(p.getDiameter())
                .thickness(p.getThickness())
                .brand(toBrandDTO(safe(p::getBrand)))
                .movement(toMovementDTO(safe(p::getMovement)))
                .glass(toGlassDTO(safe(p::getGlass)))
                .waterResistance(toWRDTO(safe(p::getWaterResistance)))
                .build();
    }


    private BrandResponse toBrandDTO(Brand b) {
        if (b == null) return null;

        return BrandResponse.builder()
                .id(b.getId())
                .name(b.getName())
                .build();
    }

    private MovementResponse toMovementDTO(Movement m) {
        if (m == null) return null;

        return MovementResponse.builder()
                .id(m.getId())
                .name(m.getName())
                .build();
    }

    private GlassResponse toGlassDTO(Glass g) {
        if (g == null) return null;

        return GlassResponse.builder()
                .id(g.getId())
                .name(g.getName())
                .build();
    }

    private WaterResistanceResponse toWRDTO(WaterResistance wr) {
        if (wr == null) return null;

        return WaterResistanceResponse.builder()
                .id(wr.getId())
                .level(wr.getLevel())
                .build();
    }

    private <T> T safe(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException ex) {
            return null;
        }
    }

}
