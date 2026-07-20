package com.infosys.HealthTwinService.model;

public class Vital {

    private String id;
    private String patientId;
    private int heartRate;
    private String bloodPressure;
    private double temperature;
    private int oxygenLevel;

    public Vital() {
    }

    public Vital(String id, String patientId, int heartRate,
                 String bloodPressure, double temperature, int oxygenLevel) {
        this.id = id;
        this.patientId = patientId;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.oxygenLevel = oxygenLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

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
}