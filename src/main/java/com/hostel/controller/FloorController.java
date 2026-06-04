package com.hostel.controller;

import com.hostel.entity.Floor;
import com.hostel.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floors")
public class FloorController {

    @Autowired
    private FloorService service;

    // ONLY PRINCIPAL CAN CREATE FLOOR
    @PreAuthorize("hasRole('PRINCIPAL')")
    @PostMapping
    public Floor saveFloor(@RequestBody Floor floor) {
        return service.saveFloor(floor);
    }

    // EVERY LOGGED-IN USER CAN VIEW FLOORS
    @GetMapping
    public List<Floor> getAllFloors() {
        return service.getAllFloors();
    }

    // ONLY PRINCIPAL CAN DELETE FLOOR
    @PreAuthorize("hasRole('PRINCIPAL')")
    @DeleteMapping("/{id}")
    public String deleteFloor(
            @PathVariable Long id) {

        service.deleteFloor(id);

        return "Floor Deleted Successfully";
    }

    // ONLY PRINCIPAL CAN UPDATE FLOOR
    @PreAuthorize("hasRole('PRINCIPAL')")
    @PutMapping("/{id}")
    public Floor updateFloor(
            @PathVariable Long id,
            @RequestBody Floor floor) {

        return service.updateFloor(id, floor);
    }
}