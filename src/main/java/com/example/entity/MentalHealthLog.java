package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mental_logs")
public class MentalHealthLog extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "input_id", nullable = false)
    private UserInputData input;

    private int moodLevel;
    private int stressLevel;
    private int meditationMinutes;
    private String note;


}
