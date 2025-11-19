package com.horacia.server.controller;

import com.horacia.server.dto.request.ProductCreateRequest;
import com.horacia.server.dto.request.ProductUpdateRequest;
import com.horacia.server.dto.response.ResponseData;
import com.horacia.server.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseData<?> creatProduct(@Valid @RequestBody ProductCreateRequest req) {
        return new ResponseData<>(HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                productService.createProduct(req));
    }

    @GetMapping
    public ResponseData<?> getAllProducts() {
        return new ResponseData<>(HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseData<?> getProduct(@PathVariable UUID id) {
        return new ResponseData<>(HttpStatus.OK.value(),
                "find product by id",
                productService.getProductById(id));
    }

    @PatchMapping("/{id}")
    public ResponseData<?> updateProduct(@PathVariable UUID id, @Valid @RequestBody ProductUpdateRequest req) {
        return new ResponseData<>(HttpStatus.OK.value(),
                "Update product successfully",
                productService.updateProduct(id, req));
    }

}
