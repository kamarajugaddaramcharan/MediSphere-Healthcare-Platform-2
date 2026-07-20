package com.infosys.explainability.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "explanations")
public class Explanation {

    @Id
    private String id;

    private String patientId;

    private String risk;

    private List<String> topFactors;

}