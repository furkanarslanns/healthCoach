package com.example.controller;

import com.example.dto.UserResponseDTO;
import com.example.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserController {
    RootEntity<UserResponseDTO> createUser(@RequestBody User user);
    RootEntity<List<UserResponseDTO>> getAllUsers();
    RootEntity<UserResponseDTO> getUser(@PathVariable Long id);
    RootEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody User user);
    RootEntity<String> deleteUser(@PathVariable Long id);

}
