package com.hostel.repository;

import com.hostel.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BedRepository
        extends JpaRepository<Bed, Long> {

    List<Bed> findByStatus(
            String status);

    long countByStatus(
            String status);

    List<Bed> findByRoomId(
            Long roomId);
}