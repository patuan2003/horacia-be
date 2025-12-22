package com.horacia.server.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageResponse {

    private String id;
    private String imageUrl;
    private Boolean isPrimary;

}
