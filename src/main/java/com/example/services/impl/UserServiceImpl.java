package com.example.services.impl;

import com.example.dto.UserResponseDTO;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    private UserResponseDTO mapToDTO(User user) {
        return new UserResponseDTO(user.getUsername(), user.getPassword());
    }

    @Override
    public UserResponseDTO saveUser(User user) {
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        return mapToDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Güncellenecek kullanıcı bulunamadı"));


        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());

        return mapToDTO(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
