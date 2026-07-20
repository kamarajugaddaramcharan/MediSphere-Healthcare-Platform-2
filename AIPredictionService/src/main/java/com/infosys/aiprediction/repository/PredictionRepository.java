package com.infosys.aiprediction.repository;

import com.infosys.aiprediction.model.RiskPrediction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends MongoRepository<RiskPrediction, String> {

    List<RiskPrediction> findByPatientId(String patientId);

}