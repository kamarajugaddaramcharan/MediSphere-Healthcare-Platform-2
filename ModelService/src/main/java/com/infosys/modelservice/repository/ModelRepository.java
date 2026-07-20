package com.infosys.modelservice.repository;

import com.infosys.modelservice.model.AIModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends MongoRepository<AIModel, String> {

}