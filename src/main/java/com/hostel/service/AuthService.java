package com.hostel.service;

import com.hostel.dto.LoginRequest;
import com.hostel.dto.LoginResponse;
import com.hostel.dto.RegisterRequest;
import com.hostel.entity.User;
import com.hostel.jwt.JwtService;
import com.hostel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // REGISTER
    public User register(RegisterRequest request) {

        User user = new User();

        user.setUsername(
                request.getUsername());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        user.setRole(
                request.getRole());

        return userRepository.save(user);
    }

    // LOGIN
    public LoginResponse login(
            LoginRequest request) {

        User user = userRepository
                .findByUsername(
                        request.getUsername())
                .orElseThrow(
                        () -> new RuntimeException(
                                "User Not Found"));

        boolean matches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword());

        if (!matches) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        String token =
                jwtService.generateToken(
                        user.getUsername());

        return new LoginResponse(
                token,
                user.getRole().name());
    }
}