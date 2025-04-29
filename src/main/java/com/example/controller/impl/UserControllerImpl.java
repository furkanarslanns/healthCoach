package com.example.controller.impl;

import com.example.controller.IUserController;
import com.example.controller.RootEntity;
import com.example.dto.UserResponseDTO;
import com.example.entity.User;
import com.example.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllerImpl implements IUserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    @Override
    public RootEntity<UserResponseDTO> createUser(@RequestBody User user) {
        return RootEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/getAll")
    @Override
    public RootEntity<List<UserResponseDTO>> getAllUsers() {
        return RootEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getUser/{id}")
    @Override
    public RootEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        return RootEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody User user) {
        return RootEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return RootEntity.ok("Kullanıcı başarıyla silindi");
    }
}
