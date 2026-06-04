package com.hostel.controller;

import com.hostel.entity.Bed;
import com.hostel.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beds")
public class BedController {

    @Autowired
    private BedService service;

    @PreAuthorize("hasRole('PRINCIPAL')")
    @PostMapping
    public Bed saveBed(
            @RequestBody Bed bed) {

        return service.saveBed(bed);
    }

    @GetMapping
    public List<Bed> getAllBeds() {

        return service.getAllBeds();
    }

    @GetMapping("/by-room/{roomId}")
    public List<Bed> getBedsByRoom(
            @PathVariable Long roomId){

        return service.getBedsByRoom(
                roomId);
    }

    @PreAuthorize("hasRole('PRINCIPAL')")
    @PutMapping("/{id}")
    public Bed updateBed(
            @PathVariable Long id,
            @RequestBody Bed bed) {

        return service.updateBed(id, bed);
    }

    @PreAuthorize("hasRole('PRINCIPAL')")
    @DeleteMapping("/{id}")
    public String deleteBed(
            @PathVariable Long id) {

        service.deleteBed(id);

        return "Bed Deleted Successfully";
    }
}