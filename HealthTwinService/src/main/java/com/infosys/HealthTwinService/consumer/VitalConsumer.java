package com.infosys.HealthTwinService.consumer;

import com.infosys.HealthTwinService.model.HealthTwin;
import com.infosys.HealthTwinService.model.Vital;
import com.infosys.HealthTwinService.service.HealthTwinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VitalConsumer {

    @Autowired
    private HealthTwinService healthTwinService;

    @KafkaListener(topics = "vitals-topic", groupId = "healthtwin-group")
    public void consume(Vital vital) {

        System.out.println("============== Kafka Message Received ==============");

        System.out.println("Patient ID      : " + vital.getPatientId());
        System.out.println("Heart Rate      : " + vital.getHeartRate());
        System.out.println("Blood Pressure  : " + vital.getBloodPressure());
        System.out.println("Temperature     : " + vital.getTemperature());
        System.out.println("Oxygen Level    : " + vital.getOxygenLevel());

        HealthTwin twin = new HealthTwin();

        twin.setPatientId(vital.getPatientId());
        twin.setHeartRate(vital.getHeartRate());
        twin.setBloodPressure(vital.getBloodPressure());
        twin.setTemperature(vital.getTemperature());
        twin.setOxygenLevel(vital.getOxygenLevel());

        // Temporary values (we'll calculate these next)
        twin.setRiskScore(0);
        twin.setStatus("Healthy");

        twin.setLastUpdated(LocalDateTime.now());

        healthTwinService.save(twin);

        System.out.println("Health Twin saved successfully");
        System.out.println("====================================================");
    }
}

