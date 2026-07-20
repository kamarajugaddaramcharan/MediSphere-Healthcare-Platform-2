package com.infosys.HealthTwinService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "healthtwins")
public class HealthTwin {

    @Id
    private String id;

    // Patient Details
    private String patientId;
    private String bloodGroup;
    private double height;
    private double weight;
    private String allergies;
    private String medicalHistory;

    // Latest Vitals
    private int heartRate;
    private String bloodPressure;
    private double temperature;
    private int oxygenLevel;

    // AI Analysis
    private int riskScore;
    private String status;

    // Last Updated
    private LocalDateTime lastUpdated;

    public HealthTwin() {
    }

    public HealthTwin(String id,
                      String patientId,
                      String bloodGroup,
                      double height,
                      double weight,
                      String allergies,
                      String medicalHistory,
                      int heartRate,
                      String bloodPressure,
                      double temperature,
                      int oxygenLevel,
                      int riskScore,
                      String status,
                      LocalDateTime lastUpdated) {

        this.id = id;
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.height = height;
        this.weight = weight;
        this.allergies = allergies;
        this.medicalHistory = medicalHistory;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.oxygenLevel = oxygenLevel;
        this.riskScore = riskScore;
        this.status = status;
        this.lastUpdated = lastUpdated;
    }

    // ================= ID =================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // ================= Patient =================

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // ================= Vitals =================

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    // ================= AI =================

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ================= Time =================

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}