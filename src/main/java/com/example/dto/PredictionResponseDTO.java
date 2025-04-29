package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredictionResponseDTO {


    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "#.##")
    private double dailyCaloriesConsumed;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "#.##")
    private double dailyWaterIntake;
    private int dailyExerciseMin;


}
