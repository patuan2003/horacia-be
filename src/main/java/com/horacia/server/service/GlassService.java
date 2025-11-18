package com.horacia.server.service;

import com.horacia.server.entity.Glass;

import java.util.List;
import java.util.UUID;

public interface GlassService {

    Glass createGlass(Glass glass);

    Glass updateGlass(UUID id, Glass glass);

    List<Glass> getAllGlass();

    Glass getGlassById(UUID id);

}
