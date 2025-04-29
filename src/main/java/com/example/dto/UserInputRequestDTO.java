package com.example.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInputRequestDTO {



    @Min(10)
    @Max(100)
    private int age;

    @NotBlank
    private String gender;

    @Min(30)
    private double currentWeightLbs;
    @Min(-100)
    @Max(100)
    private double weightChangeLbs;

    @DecimalMin("1.0")
    private double height;

    @NotBlank
    private String physicalActivityLevel;

    @Min(1)
    @Max(10)
    private int stressLevel;

    @NotBlank
    private String priorExerciseExperience;

    @NotBlank
    private String goal;

    @NotBlank
    private String sleepQuality;

    @NotBlank
    private String dailyActivityLevel;

    @Min(1)
    @Max(52)
    private int durationWeeks;


}
