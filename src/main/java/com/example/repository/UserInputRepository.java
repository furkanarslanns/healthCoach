package com.example.repository;

import com.example.entity.UserInputData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInputRepository extends JpaRepository<UserInputData, Long> {
}
