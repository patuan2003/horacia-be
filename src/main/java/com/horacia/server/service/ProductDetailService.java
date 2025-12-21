package com.horacia.server.service;

import com.horacia.server.dto.request.ProductDetailFilterRequest;
import com.horacia.server.dto.response.PageResponse;
import com.horacia.server.dto.response.ProductDetailResponse;

public interface ProductDetailService {

    PageResponse<ProductDetailResponse> getAllProductDetail(int pageNo, int pageSize, ProductDetailFilterRequest req);

}
