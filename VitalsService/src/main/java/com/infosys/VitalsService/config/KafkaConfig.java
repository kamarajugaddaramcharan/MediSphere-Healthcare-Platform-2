package com.infosys.VitalsService.config;

import com.infosys.VitalsService.model.Vital;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic vitalTopic() {
        return new NewTopic("vitals-topic", 1, (short) 1);
    }

    @Bean
    public ProducerFactory<String, Vital> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );

        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
        );

        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class
        );

        // Disable sending Java class information in Kafka headers
        config.put(
                JsonSerializer.ADD_TYPE_INFO_HEADERS,
                false
        );

        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean
    public KafkaTemplate<String, Vital> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}