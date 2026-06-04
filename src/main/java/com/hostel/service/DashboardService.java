package com.hostel.service;

import com.hostel.dto.DashboardResponse;
import com.hostel.repository.AllocationRepository;
import com.hostel.repository.BedRepository;
import com.hostel.repository.BlockRepository;
import com.hostel.repository.FloorRepository;
import com.hostel.repository.RoomRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private AllocationRepository allocationRepository;

    public DashboardResponse getDashboard() {

        DashboardResponse response =
                new DashboardResponse();

        long totalStudents =
                studentRepository.count();

        long totalBlocks =
                blockRepository.count();

        long totalFloors =
                floorRepository.count();

        long totalRooms =
                roomRepository.count();

        long totalBeds =
                bedRepository.count();

        long availableBeds =
                bedRepository.countByStatus(
                        "AVAILABLE");

        long allocatedBeds =
                bedRepository.countByStatus(
                        "ALLOCATED");

        long activeAllocations =
                allocationRepository
                        .countByStatus(
                                "ACTIVE");

        double occupancyPercentage =
                0.0;

        if(totalBeds > 0){

            occupancyPercentage =
                    ((double) allocatedBeds
                            / totalBeds) * 100;
        }

        response.setTotalStudents(
                totalStudents);

        response.setTotalBlocks(
                totalBlocks);

        response.setTotalFloors(
                totalFloors);

        response.setTotalRooms(
                totalRooms);

        response.setTotalBeds(
                totalBeds);

        response.setAvailableBeds(
                availableBeds);

        response.setAllocatedBeds(
                allocatedBeds);

        response.setActiveAllocations(
                activeAllocations);

        response.setOccupancyPercentage(
                occupancyPercentage);

        return response;
    }
}