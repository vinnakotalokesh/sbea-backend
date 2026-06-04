package com.hostel.controller;

import com.hostel.entity.Room;
import com.hostel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @PreAuthorize("hasRole('PRINCIPAL')")
    @PostMapping
    public Room saveRoom(
            @RequestBody Room room) {

        return service.saveRoom(room);
    }

    @GetMapping
    public List<Room> getAllRooms() {

        return service.getAllRooms();
    }

    @GetMapping("/by-floor/{floorId}")
    public List<Room> getRoomsByFloor(
            @PathVariable Long floorId){

        return service.getRoomsByFloor(
                floorId);
    }

    @PreAuthorize("hasRole('PRINCIPAL')")
    @PutMapping("/{id}")
    public Room updateRoom(
            @PathVariable Long id,
            @RequestBody Room room) {

        return service.updateRoom(id, room);
    }

    @PreAuthorize("hasRole('PRINCIPAL')")
    @DeleteMapping("/{id}")
    public String deleteRoom(
            @PathVariable Long id) {

        service.deleteRoom(id);

        return "Room Deleted Successfully";
    }
}