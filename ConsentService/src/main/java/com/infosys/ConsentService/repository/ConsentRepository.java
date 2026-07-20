package com.infosys.ConsentService.repository;

import com.infosys.ConsentService.model.Consent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsentRepository extends MongoRepository<Consent, String> {
}