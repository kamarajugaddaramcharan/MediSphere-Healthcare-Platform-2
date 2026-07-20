package com.infosys.aiprediction.controller;

import com.infosys.aiprediction.model.RiskPrediction;
import com.infosys.aiprediction.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prediction")
@CrossOrigin(origins = "*")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping("/cvd")
    public RiskPrediction predictCVD(@RequestBody RiskPrediction prediction) {
        return predictionService.savePrediction(prediction);
    }

    @GetMapping
    public List<RiskPrediction> getAllPredictions() {
        return predictionService.getAllPredictions();
    }

    @GetMapping("/{id}")
    public RiskPrediction getPredictionById(@PathVariable String id) {
        return predictionService.getPredictionById(id);
    }

    @GetMapping("/history/{patientId}")
    public List<RiskPrediction> getPredictionHistory(@PathVariable String patientId) {
        return predictionService.getPredictionsByPatientId(patientId);
    }

    @PutMapping("/{id}")
    public RiskPrediction updatePrediction(
            @PathVariable String id,
            @RequestBody RiskPrediction prediction) {

        return predictionService.updatePrediction(id, prediction);
    }

    @DeleteMapping("/{id}")
    public String deletePrediction(@PathVariable String id) {

        predictionService.deletePrediction(id);

        return "Prediction deleted successfully";
    }
}