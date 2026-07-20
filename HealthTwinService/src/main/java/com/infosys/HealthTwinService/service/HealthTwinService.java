package com.infosys.HealthTwinService.service;

import com.infosys.HealthTwinService.model.HealthTwin;

import java.util.List;

public interface HealthTwinService {

    HealthTwin save(HealthTwin twin);

    List<HealthTwin> getAll();

    HealthTwin getById(String id);

    HealthTwin update(String id, HealthTwin twin);

    void delete(String id);
}