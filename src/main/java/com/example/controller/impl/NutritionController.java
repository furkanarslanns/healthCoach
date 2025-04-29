package com.example.controller.impl;

import com.example.dto.FoodDTO;
import com.example.services.impl.NutritionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {
    @Autowired
    private NutritionApiService nutritionApiService;


    @GetMapping("/search")
    public ResponseEntity<java.util.List<FoodDTO>> searchFood(@RequestParam String food) {
        List<FoodDTO> foods = nutritionApiService.searchFood(food);
        return ResponseEntity.ok(foods);
    }
}
