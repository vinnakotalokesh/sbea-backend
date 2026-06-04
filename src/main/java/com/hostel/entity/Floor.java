package com.hostel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "floors")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer floorNumber;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    public Floor() {
    }

    public Floor(Long id, Integer floorNumber, Block block) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.block = block;
    }

    public Long getId() {
        return id;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public Block getBlock() {
        return block;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}