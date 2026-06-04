package com.hostel.service;

import com.hostel.entity.Block;
import com.hostel.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

    @Autowired
    private BlockRepository repository;

    public Block saveBlock(Block block) {
        return repository.save(block);
    }

    public List<Block> getAllBlocks() {
        return repository.findAll();
    }
    public void deleteBlock(Long id){
        repository.deleteById(id);
    }
    public Block updateBlock(Long id, Block block){

        Block existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Block Not Found"));

        existing.setBlockName(block.getBlockName());

        return repository.save(existing);
    }
}