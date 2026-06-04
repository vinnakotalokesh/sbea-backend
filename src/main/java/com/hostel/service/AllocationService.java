package com.hostel.service;

import com.hostel.entity.Allocation;
import com.hostel.entity.Bed;
import com.hostel.entity.Student;
import com.hostel.repository.AllocationRepository;
import com.hostel.repository.BedRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BedRepository bedRepository;

    public Allocation allocateBed(
            Long studentId,
            Long bedId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow();

        Bed bed =
                bedRepository.findById(bedId)
                        .orElseThrow();

        if (!"AVAILABLE".equals(
                bed.getStatus())) {

            throw new RuntimeException(
                    "Bed Not Available");
        }

        bed.setStatus("ALLOCATED");

        bedRepository.save(bed);

        Allocation allocation =
                new Allocation();

        allocation.setStudent(student);

        allocation.setBed(bed);

        allocation.setStatus("ACTIVE");

        return allocationRepository.save(
                allocation);
    }

    public List<Allocation>
    getAllAllocations() {

        return allocationRepository.findAll();
    }

    public Allocation vacateBed(
            Long allocationId) {

        Allocation allocation =
                allocationRepository
                        .findById(allocationId)
                        .orElseThrow();

        Bed bed =
                allocation.getBed();

        bed.setStatus("AVAILABLE");

        bedRepository.save(bed);

        allocation.setStatus(
                "VACATED");

        return allocationRepository.save(
                allocation);
    }

    public List<Allocation>
    getRoomOccupants(
            Long roomId) {

        return allocationRepository
                .findByStatus("ACTIVE")
                .stream()
                .filter(a ->
                        a.getBed()
                                .getRoom()
                                .getId()
                                .equals(roomId))
                .toList();
    }
    public List<Allocation> getActiveAllocations() {

        return allocationRepository
                .findByStatus("ACTIVE");
    }

    public long getActiveAllocationCount() {

        return allocationRepository
                .countByStatus("ACTIVE");
    }
}