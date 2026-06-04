package com.hostel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "beds")
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bedNumber;

    private String bedType;

    private String status;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Bed() {
    }

    public Bed(Long id, String bedNumber, String bedType,
               String status, Room room) {
        this.id = id;
        this.bedNumber = bedNumber;
        this.bedType = bedType;
        this.status = status;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public String getBedType() {
        return bedType;
    }

    public String getStatus() {
        return status;
    }

    public Room getRoom() {
        return room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}