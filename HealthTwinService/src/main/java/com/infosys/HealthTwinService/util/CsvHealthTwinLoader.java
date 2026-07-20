package com.infosys.HealthTwinService.util;

import com.infosys.HealthTwinService.model.HealthTwin;
import com.infosys.HealthTwinService.repository.HealthTwinRepository;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class CsvHealthTwinLoader implements CommandLineRunner {

        @Autowired
        private HealthTwinRepository repository;

        private final Random random = new Random();

        @Override
        public void run(String... args) {

                try {

                        if (repository.count() > 0) {
                                System.out.println("Health Twins already exist. Skipping import...");
                                return;
                        }

                        ClassPathResource resource = new ClassPathResource("healthtwins.csv");

                        CSVParser parser = new CSVParserBuilder()
                                .withSeparator('\t')   // TAB separated file
                                .build();

                        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(resource.getFile()))
                                .withCSVParser(parser)
                                .build()) {

                                String[] row;

                                // Skip Header
                                csvReader.readNext();

                                int count = 0;

                                while ((row = csvReader.readNext()) != null) {

                                        if (row.length < 6) {
                                                System.out.println("Skipping invalid row...");
                                                continue;
                                        }

                                        HealthTwin twin = new HealthTwin();

                                        // CSV Data
                                        twin.setPatientId(row[0].trim());
                                        twin.setBloodGroup(row[1].trim());
                                        twin.setHeight(Double.parseDouble(row[2].trim()));
                                        twin.setWeight(Double.parseDouble(row[3].trim()));
                                        twin.setAllergies(row[4].trim());
                                        twin.setMedicalHistory(row[5].trim());

                                        // Random Vitals
                                        twin.setHeartRate(60 + random.nextInt(41)); // 60-100

                                        twin.setBloodPressure(
                                                (110 + random.nextInt(31))
                                                        + "/"
                                                        + (70 + random.nextInt(21))
                                        );

                                        twin.setTemperature(
                                                Math.round((36.2 + random.nextDouble() * 1.3) * 10.0) / 10.0
                                        );

                                        twin.setOxygenLevel(95 + random.nextInt(6));

                                        // AI Risk Score
                                        int risk = random.nextInt(101);

                                        twin.setRiskScore(risk);

                                        if (risk < 30) {
                                                twin.setStatus("Healthy");
                                        } else if (risk < 70) {
                                                twin.setStatus("Moderate");
                                        } else {
                                                twin.setStatus("High Risk");
                                        }

                                        twin.setLastUpdated(LocalDateTime.now());

                                        repository.save(twin);

                                        count++;
                                }

                                System.out.println("======================================");
                                System.out.println("Imported " + count + " Health Twins");
                                System.out.println("======================================");

                        }

                } catch (IOException | CsvValidationException e) {
                        e.printStackTrace();
                }

        }
}