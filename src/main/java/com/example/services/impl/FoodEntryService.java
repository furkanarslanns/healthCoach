package com.example.services.impl;

import com.example.entity.FoodEntry;
import com.example.excaption.BaseExcaption;
import com.example.excaption.ErrorMessage;
import com.example.excaption.MessageTYPE;
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
   //--------------------------------------------------------------------
    public List<FoodEntry> getAllFoodEntries() {
        return foodEntryRepository.findAll();
    }
   //---------------------------------------------------------------------
    public void deleteFoodEntry(Long id) {
        if (!foodEntryRepository.existsById(id)) {
            throw new BaseExcaption(new ErrorMessage(MessageTYPE.No_Food,""));
        }
        foodEntryRepository.deleteById(id);
    }
    //-------------------------------------------------------------------
    public FoodEntry updateFoodEntry(Long id, FoodEntry updatedEntry) {
        FoodEntry existingEntry = foodEntryRepository.findById(id)
                .orElseThrow(() -> new BaseExcaption(new ErrorMessage(MessageTYPE.No_Food,"")));


        existingEntry.setFoodName(updatedEntry.getFoodName());
        existingEntry.setCalories(updatedEntry.getCalories());
        existingEntry.setProtein(updatedEntry.getProtein());
        existingEntry.setFat(updatedEntry.getFat());
        existingEntry.setCarbs(updatedEntry.getCarbs());

        return foodEntryRepository.save(existingEntry);
    }
}
