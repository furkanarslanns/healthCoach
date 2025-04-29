package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exercise_logs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseLog extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "input_id", nullable = false)
    private UserInputData input;

    private String exerciseType;
    private int durationMinutes;
    private double caloriesBurned;


}
