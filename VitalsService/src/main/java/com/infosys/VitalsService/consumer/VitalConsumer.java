package com.infosys.VitalsService.consumer;

import com.infosys.VitalsService.model.Vital;
import com.infosys.VitalsService.repository.VitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class VitalConsumer {

    @Autowired
    private VitalRepository repository;

    @KafkaListener(topics = "patient-vitals", groupId = "vitals-group")
    public void consume(Vital vital) {

        repository.save(vital);

        System.out.println("Vital Saved Successfully");
        System.out.println("Patient ID : " + vital.getPatientId());
        System.out.println("Heart Rate : " + vital.getHeartRate());
    }
}