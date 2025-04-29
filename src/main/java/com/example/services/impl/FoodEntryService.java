package com.example.services.impl;

import com.example.entity.FoodEntry;
import com.example.repository.FoodEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodEntryService {
    @Autowired
    private FoodEntryRepository foodEntryRepository;
    public FoodEntry saveFoodEntry(String foodName, Double calories, Double protein, Double fat, Double carbs) {
        FoodEntry foodEntry = new FoodEntry(foodName, calories, protein, fat, carbs, LocalDateTime.now());
        return foodEntryRepository.save(foodEntry);
    }

    public List<FoodEntry> getAllFoodEntries() {
        return foodEntryRepository.findAll();
    }
}
