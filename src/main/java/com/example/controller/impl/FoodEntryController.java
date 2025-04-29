package com.example.controller.impl;

import com.example.entity.FoodEntry;
import com.example.services.impl.FoodEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-entry")
public class FoodEntryController {

    @Autowired
    FoodEntryService foodEntryService;
    @PostMapping("/save")
    public ResponseEntity<FoodEntry> saveFoodEntry(@RequestBody FoodEntry foodEntry) {
        FoodEntry saved = foodEntryService.saveFoodEntry(
                foodEntry.getFoodName(),
                foodEntry.getCalories(),
                foodEntry.getProtein(),
                foodEntry.getFat(),
                foodEntry.getCarbs()
        );
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodEntry>> getAllFoodEntries() {
        return ResponseEntity.ok(foodEntryService.getAllFoodEntries());
    }
}
