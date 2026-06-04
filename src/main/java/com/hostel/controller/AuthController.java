package com.hostel.controller;

import com.hostel.dto.RegisterRequest;
import com.hostel.entity.User;
import com.hostel.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hostel.dto.LoginRequest;
import com.hostel.dto.LoginResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequest request){

        return authService.register(request);
    }
    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request){

        return authService.login(request);
    }
}