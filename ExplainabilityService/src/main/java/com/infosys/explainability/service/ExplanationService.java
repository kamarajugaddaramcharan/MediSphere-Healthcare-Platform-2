package com.infosys.explainability.service;

import com.infosys.explainability.model.Explanation;

import java.util.List;

public interface ExplanationService {

    Explanation generateExplanation(String patientId);

    Explanation getExplanation(String patientId);

    List<Explanation> getAllExplanations();

    void deleteExplanation(String patientId);

}