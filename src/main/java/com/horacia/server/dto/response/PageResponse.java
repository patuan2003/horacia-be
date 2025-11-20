package com.horacia.server.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
public class PageResponse<T> implements Serializable {

    private int pageNo;
    private int pageSize;
    private int totalPage;
    private long totalItems;

    private List<T> items;

}
