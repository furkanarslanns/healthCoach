package com.example.controller.impl;

import com.example.controller.IPredictionController;
import com.example.controller.RootEntity;
import com.example.dto.PredictionResponseDTO;
import com.example.dto.UserInputRequestDTO;
import com.example.services.impl.PredictionServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controller.RootEntity.ok;
@RestController
@RequestMapping("/predict")
public class PredictionControllerImpl implements IPredictionController {
    @Autowired
    PredictionServiceImpl predictionService;

    @PostMapping
    @Override
    public RootEntity<PredictionResponseDTO> getPrediction(@Valid @RequestBody UserInputRequestDTO requestDTO) {

        return ok(predictionService.getPrediction(requestDTO));
    }
}
