package com.example.services.impl;

import com.example.dto.ExerciseLogDto;
import com.example.entity.ExerciseLog;
import com.example.repository.ExerciseLogRepository;
import com.example.services.IExerciseLogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseLogServices implements IExerciseLogServices {
    @Autowired
    ExerciseLogRepository exerciseLogRepository;
    @Override
    public ExerciseLogDto saveExerciseLog(ExerciseLog exerciseLog) {

        return null;
    }
}
