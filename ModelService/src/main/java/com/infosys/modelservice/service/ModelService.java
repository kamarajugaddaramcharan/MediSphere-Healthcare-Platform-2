package com.infosys.modelservice.service;

import com.infosys.modelservice.model.AIModel;

import java.util.List;

public interface ModelService {

    AIModel saveModel(AIModel model);

    List<AIModel> getAllModels();

    AIModel getModelById(String id);

    AIModel updateModel(String id, AIModel model);

    void deleteModel(String id);

}