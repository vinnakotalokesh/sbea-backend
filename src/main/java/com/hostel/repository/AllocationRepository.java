package com.hostel.repository;

import com.hostel.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocationRepository
        extends JpaRepository<Allocation, Long> {

    List<Allocation> findByStatus(
            String status);

    long countByStatus(
            String status);
}