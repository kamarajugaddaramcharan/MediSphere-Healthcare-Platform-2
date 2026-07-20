package com.infosys.FHIRService.service.impl;

import com.infosys.FHIRService.client.PatientClient;
import com.infosys.FHIRService.model.FhirRecord;
import com.infosys.FHIRService.model.Patient;
import com.infosys.FHIRService.repository.FhirRepository;
import com.infosys.FHIRService.service.FhirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FhirServiceImpl implements FhirService {

    @Autowired
    private FhirRepository repository;

    @Autowired
    private PatientClient patientClient;

    @Override
    public FhirRecord save(FhirRecord record) {
        return repository.save(record);
    }

    @Override
    public List<FhirRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public FhirRecord getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public FhirRecord update(String id, FhirRecord record) {

        FhirRecord existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setPatientId(record.getPatientId());
            existing.setResourceType(record.getResourceType());
            existing.setResourceData(record.getResourceData());
            existing.setCreatedAt(record.getCreatedAt());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public String generatePatientFHIR(String patientId) {

        Patient patient = patientClient.getPatientById(patientId);

        if (patient == null) {
            return "Patient not found";
        }

        return "{\n" +
                "\"resourceType\":\"Patient\",\n" +
                "\"id\":\"" + patient.getPatientId() + "\",\n" +
                "\"name\":[{\"text\":\"" + patient.getName() + "\"}],\n" +
                "\"gender\":\"" + patient.getGender() + "\",\n" +
                "\"address\":[{\"text\":\"" + patient.getAddress() + "\"}],\n" +
                "\"telecom\":[{\"value\":\"" + patient.getPhone() + "\"}]\n" +
                "}";
    }
}