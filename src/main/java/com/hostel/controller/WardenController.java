package com.hostel.controller;

import com.hostel.entity.User;
import com.hostel.enums.Role;
import com.hostel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wardens")
public class WardenController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getWardens() {

        return userRepository
                .findAll()
                .stream()
                .filter(user ->
                        user.getRole()
                                == Role.WARDEN)
                .toList();
    }

    @PostMapping
    public User addWarden(
            @RequestBody User user) {

        user.setRole(
                Role.WARDEN);

        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()));

        return userRepository.save(
                user);
    }

    @DeleteMapping("/{id}")
    public void deleteWarden(
            @PathVariable Long id) {

        userRepository.deleteById(
                id);
    }
}