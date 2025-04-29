package com.example.services;

import com.example.dto.UserResponseDTO;
import com.example.entity.User;

import java.util.List;

public interface IUserService {
    UserResponseDTO saveUser(User user);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    UserResponseDTO updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}
