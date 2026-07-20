package com.infosys.VitalsService.service.impl;

import com.infosys.VitalsService.model.Vital;
import com.infosys.VitalsService.producer.VitalProducer;
import com.infosys.VitalsService.repository.VitalRepository;
import com.infosys.VitalsService.service.VitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalServiceImpl implements VitalService {

    @Autowired
    private VitalRepository repository;

    @Autowired
    private VitalProducer vitalProducer;

    @Override
    public Vital saveVital(Vital vital) {

        Vital savedVital = repository.save(vital);

        // Send to Kafka
        vitalProducer.sendVital(savedVital);

        return savedVital;
    }

    @Override
    public List<Vital> getAllVitals() {
        return repository.findAll();
    }

    @Override
    public Vital getVitalById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vital updateVital(String id, Vital vital) {

        Vital existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setPatientId(vital.getPatientId());
            existing.setHeartRate(vital.getHeartRate());
            existing.setBloodPressure(vital.getBloodPressure());
            existing.setTemperature(vital.getTemperature());
            existing.setOxygenLevel(vital.getOxygenLevel());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteVital(String id) {
        repository.deleteById(id);
    }
}