package com.horacia.server.specification;

import com.horacia.server.dto.request.ProductDetailFilterRequest;
import com.horacia.server.entity.DiaColor;
import com.horacia.server.entity.Product;
import com.horacia.server.entity.ProductDetails;
import com.horacia.server.entity.Strap;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailSpecification {

    public static Specification<ProductDetails> filter(ProductDetailFilterRequest req) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<ProductDetails, Product> product = root.join("product", JoinType.LEFT);
            Join<ProductDetails, Strap> strap = root.join("strap", JoinType.LEFT);
            Join<ProductDetails, DiaColor> diaColor = root.join("diaColor", JoinType.LEFT);

            if (req.getProductId() != null) {
                predicates.add(product.get("id").in(req.getProductId()));
            }

            if (req.getBrandId() != null) {
                predicates.add(product.get("brand").get("id").in(req.getBrandId()));
            }

            if (req.getMovementId() != null) {
                predicates.add(product.get("movement").get("id").in(req.getMovementId()));
            }

            if (req.getGlassId() != null) {
                predicates.add(product.get("glass").get("id").in(req.getGlassId()));
            }

            if (req.getWaterResistanceId() != null) {
                predicates.add(product.get("waterResistance").get("id").in(req.getWaterResistanceId()));
            }

            if (req.getStrapId() != null) {
                predicates.add(root.get("strap").get("id").in(req.getStrapId()));
            }

            if (req.getDiaColorId() != null) {
                predicates.add(root.get("diaColor").get("id").in(req.getDiaColorId()));
            }

            if (req.getProductName() != null && !req.getProductName().isBlank()) {
                String keyword = "%" + req.getProductName().toLowerCase() + "%";
                predicates.add(
                        cb.like(
                                cb.lower(product.get("name")), keyword
                        )
                );
            }

            if (req.getStrapName() != null && !req.getStrapName().isBlank()) {
                String keyword = "%" + req.getStrapName().toLowerCase() + "%";
                predicates.add(
                        cb.like(
                                cb.lower(strap.get("name")), keyword
                        )
                );
            }

            if (req.getDiaColorName() != null && !req.getDiaColorName().isBlank()) {
                String keyword = "%" + req.getDiaColorName().toLowerCase() + "%";
                predicates.add(
                        cb.like(
                                cb.lower(diaColor.get("name")), keyword
                        )
                );
            }

            query.distinct(true);

            return cb.and(predicates.toArray(new Predicate[0]));
        };

    }

}
