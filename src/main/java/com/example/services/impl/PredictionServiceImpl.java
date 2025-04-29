package com.example.services.impl;

import com.example.dto.PredictionResponseDTO;
import com.example.dto.UserInputRequestDTO;
import com.example.services.IPredictionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PredictionServiceImpl implements IPredictionService {
    private final RestTemplate restTemplate;
    private final String mlApiUrl;
    public PredictionServiceImpl(
            RestTemplate restTemplate,
            @Value("${ml.api.url}") String mlApiUrl
    ) {
        this.restTemplate = restTemplate;
        this.mlApiUrl = mlApiUrl;
    }


    @Override
    public PredictionResponseDTO getPrediction(UserInputRequestDTO requestDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserInputRequestDTO> requestEntity = new HttpEntity<>(requestDTO, headers);

        ResponseEntity<PredictionResponseDTO> response = restTemplate.postForEntity(
                mlApiUrl + "/predict", requestEntity, PredictionResponseDTO.class
        );

        return response.getBody();
    }
}
