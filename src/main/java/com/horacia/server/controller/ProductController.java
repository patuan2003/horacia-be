package com.horacia.server.controller;

import com.horacia.server.dto.request.ProductRequest;
import com.horacia.server.dto.response.ResponseData;
import com.horacia.server.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseData<?> creatProduct(@Valid @RequestBody ProductRequest req) {
        return new ResponseData<>(HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                productService.createProduct(req));
    }

}
