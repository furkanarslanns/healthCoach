package com.example.repository;

import com.example.entity.FoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodEntryRepository extends JpaRepository<FoodEntry, Long> {
}
