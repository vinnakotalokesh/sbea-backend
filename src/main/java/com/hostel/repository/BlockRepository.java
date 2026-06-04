package com.hostel.repository;

import com.hostel.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository
        extends JpaRepository<Block, Long> {
}