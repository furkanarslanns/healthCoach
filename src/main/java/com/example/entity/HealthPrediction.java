package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "health_predictions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthPrediction extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "input_id", nullable = false)
    private UserInputData input;

    // ML model tahminleri
    @Column(name = "daily_calories_consumed")
    private double dailyCaloriesConsumed;

    @Column(name = "Daily_Water_Intake_(L)")
    private double dailyWaterIntake;

    @Column(name = "Daily_Exercise_(min)")
    private int dailyExerciseMin;

}
