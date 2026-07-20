package com.infosys.HealthTwinService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class HealthTwinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthTwinServiceApplication.class, args);
	}
}