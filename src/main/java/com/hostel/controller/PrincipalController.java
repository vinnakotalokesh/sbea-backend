package com.hostel.controller;

import com.hostel.dto.RegisterRequest;
import com.hostel.entity.User;
import com.hostel.enums.Role;
import com.hostel.repository.UserRepository;
import com.hostel.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/principals")
public class PrincipalController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createPrincipal(
            @RequestBody RegisterRequest request) {

        request.setRole(
                Role.PRINCIPAL);

        return authService.register(
                request);
    }

    @GetMapping
    public List<User> getPrincipals() {

        return userRepository.findByRole(
                Role.PRINCIPAL);
    }

    @DeleteMapping("/{id}")
    public void deletePrincipal(
            @PathVariable Long id) {

        userRepository.deleteById(id);
    }
}