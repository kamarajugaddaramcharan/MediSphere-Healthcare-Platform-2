package com.infosys.FHIRService.client;

import com.infosys.FHIRService.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PATIENT_SERVICE_URL =
            "http://localhost:8080/patients/";

    public Patient getPatientById(String patientId) {
        return restTemplate.getForObject(
                PATIENT_SERVICE_URL + patientId,
                Patient.class
        );
    }
}