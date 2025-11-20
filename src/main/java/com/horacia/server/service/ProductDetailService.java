package com.horacia.server.service;

import com.horacia.server.dto.response.PageResponse;

public interface ProductDetailService {

    PageResponse<?> getAllProductDetails(int page, int size);

}
