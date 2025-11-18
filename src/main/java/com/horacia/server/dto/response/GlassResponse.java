package com.horacia.server.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class GlassResponse {

    private UUID id;
    private String name;

}
