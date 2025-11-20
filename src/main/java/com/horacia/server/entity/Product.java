package com.horacia.server.entity;

import com.horacia.server.util.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "model_code")
    private String modelCode;

    @Column(name = "diameter")
    private BigDecimal diameter;

    @Column(name = "thickness")
    private BigDecimal thickness;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "movement_id")
    private Movement movement;

    @ManyToOne
    @JoinColumn(name = "glass_id")
    private Glass glass;

    @ManyToOne
    @JoinColumn(name = "water_resistance_id")
    private WaterResistance waterResistance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
