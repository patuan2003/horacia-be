package com.horacia.server.controller;

import com.horacia.server.dto.response.ResponseData;
import com.horacia.server.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-details")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    @GetMapping
    public ResponseData<?> getAllProductDetail(@RequestParam Integer pageNo,
                                               @RequestParam Integer pageSize) {
        return new ResponseData<>(HttpStatus.OK.value(),
                "Get all product detail",
                productDetailService.getAllProductDetails(pageNo, pageSize));
    }

}
