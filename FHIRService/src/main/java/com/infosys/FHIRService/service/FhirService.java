package com.infosys.FHIRService.service;

import com.infosys.FHIRService.model.FhirRecord;

import java.util.List;

public interface FhirService {

    FhirRecord save(FhirRecord record);

    List<FhirRecord> getAll();

    FhirRecord getById(String id);

    FhirRecord update(String id, FhirRecord record);

    void delete(String id);

    String generatePatientFHIR(String patientId);
}