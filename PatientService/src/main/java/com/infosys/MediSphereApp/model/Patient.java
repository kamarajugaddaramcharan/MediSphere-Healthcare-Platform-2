package com.infosys.MediSphereApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
public class Patient {

    @Id
    private String id;

    private String patientId;
    private int age;
    private String gender;
    private String medicalCondition;
    private String treatment;
    private String outcome;
    private String insuranceType;
    private double income;
    private String region;
    private String smokingStatus;
    private String admissionType;
    private String hospitalId;
    private int lengthOfStay;

    public Patient() {
    }

    public Patient(String id, String patientId, int age, String gender,
                   String medicalCondition, String treatment,
                   String outcome, String insuranceType,
                   double income, String region,
                   String smokingStatus, String admissionType,
                   String hospitalId, int lengthOfStay) {

        this.id = id;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.treatment = treatment;
        this.outcome = outcome;
        this.insuranceType = insuranceType;
        this.income = income;
        this.region = region;
        this.smokingStatus = smokingStatus;
        this.admissionType = admissionType;
        this.hospitalId = hospitalId;
        this.lengthOfStay = lengthOfStay;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", medicalCondition='" + medicalCondition + '\'' +
                ", treatment='" + treatment + '\'' +
                ", outcome='" + outcome + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", income=" + income +
                ", region='" + region + '\'' +
                ", smokingStatus='" + smokingStatus + '\'' +
                ", admissionType='" + admissionType + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", lengthOfStay=" + lengthOfStay +
                '}';
    }
}