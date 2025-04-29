package com.example.controller;

import com.example.dto.PredictionResponseDTO;
import com.example.dto.UserInputRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPredictionController {
    RootEntity<PredictionResponseDTO> getPrediction(UserInputRequestDTO requestDTO);
}
