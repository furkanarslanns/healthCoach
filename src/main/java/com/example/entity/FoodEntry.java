package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Food_Entry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FoodEntry {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private Double calories;
    private Double protein;
    private Double fat;
    private Double carbs;
    private LocalDateTime eatenAt;
    public FoodEntry(String foodName, Double calories, Double protein, Double fat, Double carbs, LocalDateTime eatenAt) {
        this.foodName = foodName;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.eatenAt = eatenAt;
    }
}
