package com.example.dto;

import com.example.entity.UserInputData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseLogDto {


    private String exerciseType;
    private int durationMinutes;
    private double caloriesBurned;



}
