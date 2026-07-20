package com.infosys.explainability.service;

import com.infosys.explainability.model.Explanation;
import com.infosys.explainability.repository.ExplanationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExplanationServiceImpl implements ExplanationService {

    @Autowired
    private ExplanationRepository repository;

    @Override
    public Explanation generateExplanation(String patientId) {

        Explanation explanation = repository.findByPatientId(patientId)
                .orElse(new Explanation());

        explanation.setPatientId(patientId);

        List<String> factors = new ArrayList<>();

        factors.add("High Blood Pressure");
        factors.add("High Cholesterol");
        factors.add("Diabetes History");
        factors.add("Smoking");
        factors.add("BMI > 30");

        explanation.setRisk("HIGH");
        explanation.setTopFactors(factors);

        return repository.save(explanation);
    }

    @Override
    public Explanation getExplanation(String patientId) {
        return repository.findByPatientId(patientId).orElse(null);
    }

    @Override
    public List<Explanation> getAllExplanations() {
        return repository.findAll();
    }

    @Override
    public void deleteExplanation(String patientId) {

        repository.findByPatientId(patientId)
                .ifPresent(repository::delete);

    }
}