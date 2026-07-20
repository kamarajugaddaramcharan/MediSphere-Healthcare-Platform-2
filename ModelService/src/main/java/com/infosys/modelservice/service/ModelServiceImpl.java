package com.infosys.modelservice.service;

import com.infosys.modelservice.model.AIModel;
import com.infosys.modelservice.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository repository;

    @Override
    public AIModel saveModel(AIModel model) {
        model.setCreatedDate(LocalDate.now());
        return repository.save(model);
    }

    @Override
    public List<AIModel> getAllModels() {
        return repository.findAll();
    }

    @Override
    public AIModel getModelById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AIModel updateModel(String id, AIModel model) {

        AIModel existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setModelName(model.getModelName());
            existing.setVersion(model.getVersion());
            existing.setAlgorithm(model.getAlgorithm());
            existing.setStatus(model.getStatus());
            existing.setDescription(model.getDescription());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteModel(String id) {
        repository.deleteById(id);
    }
}