package com.horacia.server.controller;

import com.horacia.server.dto.request.ProductDetailFilterRequest;
import com.horacia.server.dto.response.PageResponse;
import com.horacia.server.dto.response.ResponseData;
import com.horacia.server.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-details")
@RequiredArgsConstructor
public class ProductDetailController {

    private  final ProductDetailService productDetailService;

    @GetMapping
    public ResponseData<?> getAllProductDetail(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                               @RequestParam(defaultValue = "5", required = false) int pageSize,
                                               @ModelAttribute ProductDetailFilterRequest req) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(productDetailService.getAllProductDetail(pageNo, pageSize, req))
                .build();
    }

}
