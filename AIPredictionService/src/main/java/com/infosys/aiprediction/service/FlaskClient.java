package com.infosys.aiprediction.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FlaskClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> predict(double[] features) {

        String url = "http://localhost:5000/predict";

        Map<String, Object> body = new HashMap<>();
        body.put("features", features);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, request, Map.class);

        return response.getBody();
    }
}