package com.example.services;

import com.example.dto.PredictionResponseDTO;
import com.example.dto.UserInputRequestDTO;

public interface IPredictionService {
    PredictionResponseDTO getPrediction(UserInputRequestDTO requestDTO);
}
