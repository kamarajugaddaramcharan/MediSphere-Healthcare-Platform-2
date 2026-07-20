package com.infosys.VitalsService.repository;

import com.infosys.VitalsService.model.Vital;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VitalRepository extends MongoRepository<Vital, String> {
}