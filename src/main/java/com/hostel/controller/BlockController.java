package com.hostel.controller;

import com.hostel.entity.Block;
import com.hostel.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    @Autowired
    private BlockService service;

    // ONLY PRINCIPAL CAN CREATE BLOCK
    @PreAuthorize("hasRole('PRINCIPAL')")
    @PostMapping
    public Block saveBlock(@RequestBody Block block) {
        return service.saveBlock(block);
    }

    // EVERY LOGGED-IN USER CAN VIEW BLOCKS
    @GetMapping
    public List<Block> getAllBlocks() {
        return service.getAllBlocks();
    }

    // ONLY PRINCIPAL CAN DELETE BLOCK
    @PreAuthorize("hasRole('PRINCIPAL')")
    @DeleteMapping("/{id}")
    public String deleteBlock(
            @PathVariable Long id) {

        service.deleteBlock(id);

        return "Block Deleted Successfully";
    }

    // ONLY PRINCIPAL CAN UPDATE BLOCK
    @PreAuthorize("hasRole('PRINCIPAL')")
    @PutMapping("/{id}")
    public Block updateBlock(
            @PathVariable Long id,
            @RequestBody Block block) {

        return service.updateBlock(id, block);
    }
}