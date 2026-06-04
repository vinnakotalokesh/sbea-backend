package com.hostel.service;

import com.hostel.entity.Floor;
import com.hostel.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {

    @Autowired
    private FloorRepository repository;

    public Floor saveFloor(Floor floor){
        return repository.save(floor);
    }

    public List<Floor> getAllFloors(){
        return repository.findAll();
    }
    public void deleteFloor(Long id) {
        repository.deleteById(id);
    }
    public Floor updateFloor(Long id, Floor floor){

        Floor existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Floor Not Found"));

        existing.setFloorNumber(
                floor.getFloorNumber());

        return repository.save(existing);
    }
}