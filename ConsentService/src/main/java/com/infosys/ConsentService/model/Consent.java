package com.infosys.ConsentService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consents")
public class Consent {

    @Id
    private String id;

    private String patientId;
    private String doctorId;
    private String resourceType;
    private String permission;
    private String status;

    public Consent() {
    }

    public Consent(String id, String patientId, String doctorId,
                   String resourceType, String permission, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.resourceType = resourceType;
        this.permission = permission;
        this.status = status;
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}