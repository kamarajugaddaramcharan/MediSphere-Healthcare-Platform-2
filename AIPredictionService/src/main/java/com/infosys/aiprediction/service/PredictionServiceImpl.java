package com.infosys.aiprediction.service;

import com.infosys.aiprediction.model.RiskPrediction;
import com.infosys.aiprediction.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PredictionServiceImpl implements PredictionService {

    @Autowired
    private PredictionRepository predictionRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public RiskPrediction savePrediction(RiskPrediction prediction) {

        try {

            String flaskUrl = "http://localhost:5000/predict";

            double[] features = {
                    prediction.getAge() == null ? 0 : prediction.getAge(),
                    prediction.getSex() == null ? 0 : prediction.getSex(),
                    prediction.getChestPainType() == null ? 0 : prediction.getChestPainType(),
                    prediction.getRestingBloodPressure() == null ? 0 : prediction.getRestingBloodPressure(),
                    prediction.getCholesterol() == null ? 0 : prediction.getCholesterol(),
                    prediction.getFastingBloodSugar() == null ? 0 : prediction.getFastingBloodSugar(),
                    prediction.getRestingECG() == null ? 0 : prediction.getRestingECG(),
                    prediction.getMaxHeartRate() == null ? 0 : prediction.getMaxHeartRate(),
                    prediction.getExerciseInducedAngina() == null ? 0 : prediction.getExerciseInducedAngina(),
                    prediction.getOldPeak() == null ? 0 : prediction.getOldPeak(),
                    prediction.getSlope() == null ? 0 : prediction.getSlope(),
                    prediction.getMajorVessels() == null ? 0 : prediction.getMajorVessels(),
                    prediction.getThal() == null ? 0 : prediction.getThal()
            };

            Map<String, Object> request = new HashMap<>();
            request.put("features", features);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity =
                    new HttpEntity<>(request, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(flaskUrl, entity, Map.class);

            Map<?, ?> body = response.getBody();

            if (body != null) {

                double probability = Double.parseDouble(body.get("probability").toString());
                int result = Integer.parseInt(body.get("prediction").toString());

                prediction.setRiskPercentage(probability * 100);

                if (result == 1) {
                    prediction.setRiskLevel("HIGH");
                } else {
                    prediction.setRiskLevel("LOW");
                }

                prediction.setConfidence(probability * 100);
            }

        } catch (Exception e) {

            prediction.setRiskPercentage(0.0);
            prediction.setRiskLevel("UNKNOWN");
            prediction.setConfidence(0.0);

            e.printStackTrace();
        }

        prediction.setPredictionDate(LocalDate.now());
        prediction.setModelVersion("TensorFlow v1.0");

        return predictionRepository.save(prediction);
    }

    @Override
    public List<RiskPrediction> getAllPredictions() {
        return predictionRepository.findAll();
    }

    @Override
    public RiskPrediction getPredictionById(String id) {
        return predictionRepository.findById(id).orElse(null);
    }

    @Override
    public List<RiskPrediction> getPredictionsByPatientId(String patientId) {
        return predictionRepository.findByPatientId(patientId);
    }

    @Override
    public RiskPrediction updatePrediction(String id, RiskPrediction prediction) {

        RiskPrediction existing = predictionRepository.findById(id).orElse(null);

        if (existing != null) {
            prediction.setId(existing.getId());
            return savePrediction(prediction);
        }

        return null;
    }

    @Override
    public void deletePrediction(String id) {
        predictionRepository.deleteById(id);
    }
}