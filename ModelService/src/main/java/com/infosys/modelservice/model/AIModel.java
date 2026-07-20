package com.infosys.modelservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "models")
public class AIModel {

    @Id
    private String id;

    private String modelName;
    private String version;
    private String algorithm;
    private String status;
    private String description;
    private LocalDate createdDate;

}