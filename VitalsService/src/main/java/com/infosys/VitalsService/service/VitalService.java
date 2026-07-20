package com.infosys.VitalsService.service;

import com.infosys.VitalsService.model.Vital;

import java.util.List;

public interface VitalService {

    Vital saveVital(Vital vital);

    List<Vital> getAllVitals();

    Vital getVitalById(String id);

    Vital updateVital(String id, Vital vital);

    void deleteVital(String id);
}