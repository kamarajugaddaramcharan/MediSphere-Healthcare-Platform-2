package com.infosys.explainability.repository;

import com.infosys.explainability.model.Explanation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExplanationRepository extends MongoRepository<Explanation, String> {

    Optional<Explanation> findByPatientId(String patientId);

}