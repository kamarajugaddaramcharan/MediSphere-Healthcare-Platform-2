package com.infosys.FHIRService.repository;

import com.infosys.FHIRService.model.FhirRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FhirRepository extends MongoRepository<FhirRecord, String> {
}