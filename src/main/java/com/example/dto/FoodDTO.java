package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private Double calories;
    private Double protein;
    private Double fat;
    private Double carbs;
}
