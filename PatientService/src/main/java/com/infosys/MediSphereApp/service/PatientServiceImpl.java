package com.infosys.MediSphereApp.service;

import com.infosys.MediSphereApp.model.Patient;
import com.infosys.MediSphereApp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    @Override
    public Patient getPatientById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Patient updatePatient(String id, Patient patient) {

        Patient existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setPatientId(patient.getPatientId());
            existing.setAge(patient.getAge());
            existing.setGender(patient.getGender());
            existing.setMedicalCondition(patient.getMedicalCondition());
            existing.setTreatment(patient.getTreatment());
            existing.setOutcome(patient.getOutcome());
            existing.setInsuranceType(patient.getInsuranceType());
            existing.setIncome(patient.getIncome());
            existing.setRegion(patient.getRegion());
            existing.setSmokingStatus(patient.getSmokingStatus());
            existing.setAdmissionType(patient.getAdmissionType());
            existing.setHospitalId(patient.getHospitalId());
            existing.setLengthOfStay(patient.getLengthOfStay());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deletePatient(String id) {
        repository.deleteById(id);
    }
}