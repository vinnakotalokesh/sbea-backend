package com.hostel.controller;

import com.hostel.entity.Allocation;
import com.hostel.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allocation")
public class AllocationController {

    @Autowired
    private AllocationService service;

    // ALLOCATE BED
    @PreAuthorize("hasRole('WARDEN')")
    @PostMapping
    public Allocation allocateBed(
            @RequestParam Long studentId,
            @RequestParam Long bedId) {

        return service.allocateBed(
                studentId,
                bedId);
    }

    // VIEW ALL ALLOCATIONS
    @GetMapping
    public List<Allocation> getAllAllocations() {

        return service.getAllAllocations();
    }

    // VACATE BED
    @PreAuthorize("hasRole('WARDEN')")
    @PostMapping("/vacate")
    public Allocation vacateBed(
            @RequestParam Long allocationId) {

        return service.vacateBed(
                allocationId);
    }
    @GetMapping("/room/{roomId}")
    public List<Allocation>
    getRoomOccupants(
            @PathVariable Long roomId){

        return service.getRoomOccupants(
                roomId);
    }
    @GetMapping("/active")
    public List<Allocation> getActiveAllocations() {

        return service.getActiveAllocations();
    }
}