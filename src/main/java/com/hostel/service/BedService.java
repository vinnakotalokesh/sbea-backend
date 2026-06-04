package com.hostel.service;

import com.hostel.entity.Bed;
import com.hostel.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {

    @Autowired
    private BedRepository repository;

    public Bed saveBed(Bed bed){
        return repository.save(bed);
    }

    public List<Bed> getAllBeds(){
        return repository.findAll();
    }

    public List<Bed> getBedsByRoom(
            Long roomId){

        return repository.findByRoomId(
                roomId);
    }

    public void deleteBed(Long id){
        repository.deleteById(id);
    }

    public Bed updateBed(
            Long id,
            Bed bed){

        Bed existing =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Bed Not Found"));

        existing.setBedNumber(
                bed.getBedNumber());

        existing.setBedType(
                bed.getBedType());

        existing.setStatus(
                bed.getStatus());

        return repository.save(existing);
    }
}