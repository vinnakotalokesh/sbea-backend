package com.hostel.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/principal-test")
    @PreAuthorize("hasRole('PRINCIPAL')")
    public String principalTest() {

        return "Principal Access Granted";
    }

    @GetMapping("/warden-test")
    @PreAuthorize("hasRole('WARDEN')")
    public String wardenTest() {

        return "Warden Access Granted";
    }

    @GetMapping("/head-test")
    @PreAuthorize("hasRole('HEAD_OF_CAMPUS')")
    public String headTest() {

        return "Head Access Granted";
    }
}