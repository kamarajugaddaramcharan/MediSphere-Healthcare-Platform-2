package com.infosys.VitalsService.producer;

import com.infosys.VitalsService.model.Vital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VitalProducer {

    private static final String TOPIC = "vitals-topic";

    @Autowired
    private KafkaTemplate<String, Vital> kafkaTemplate;

    public void sendVital(Vital vital) {

        kafkaTemplate.send(TOPIC, vital);

        System.out.println("=================================");
        System.out.println("Vital sent to Kafka");
        System.out.println("Patient ID : " + vital.getPatientId());
        System.out.println("=================================");
    }
}