package com.infosys.MediSphereApp.repository;

import com.infosys.MediSphereApp.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

}