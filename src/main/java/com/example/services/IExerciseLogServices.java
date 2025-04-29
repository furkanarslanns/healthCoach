package com.example.services;

import com.example.dto.ExerciseLogDto;
import com.example.entity.ExerciseLog;

public interface IExerciseLogServices {
    public ExerciseLogDto saveExerciseLog(ExerciseLog exerciseLog);
}
