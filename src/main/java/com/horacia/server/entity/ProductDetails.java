package com.horacia.server.entity;

import com.horacia.server.util.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_details")
public class ProductDetails extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "strap_id")
    private Strap strap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dia_color_id")
    private DiaColor diaColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "productDetail")
    private List<ProductDetailImage> productDetailImageList;

}
