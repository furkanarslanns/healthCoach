package com.example.entity;

import com.example.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_inputs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInputData extends BaseEntity{
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private double currentWeightLbs;
    private double weightChangeLbs;
    private double height;
    @Enumerated(EnumType.STRING)
    private PhysicalActivityLevel physicalActivityLevel;
    private int stressLevel;
    @Enumerated(EnumType.STRING)
    private ExerciseExperience priorExerciseExperience;
    @Enumerated(EnumType.STRING)
    private UserGoal goal;
    @Enumerated(EnumType.STRING)
    private SleepQuality sleepQuality;
    @Enumerated(EnumType.STRING)
    private DailyActivityLevel dailyActivityLevel;
    private int durationWeeks;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne(mappedBy = "input", cascade = CascadeType.ALL)
    private HealthPrediction prediction;


}
