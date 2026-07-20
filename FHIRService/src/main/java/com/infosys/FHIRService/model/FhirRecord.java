package com.infosys.FHIRService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fhirrecords")
public class FhirRecord {

    @Id
    private String id;

    private String patientId;

    private String resourceType;

    private String resourceData;

    private String createdAt;

    public FhirRecord() {
    }

    public FhirRecord(String id, String patientId, String resourceType,
                      String resourceData, String createdAt) {
        this.id = id;
        this.patientId = patientId;
        this.resourceType = resourceType;
        this.resourceData = resourceData;
        this.createdAt = createdAt;
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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceData() {
        return resourceData;
    }

    public void setResourceData(String resourceData) {
        this.resourceData = resourceData;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}