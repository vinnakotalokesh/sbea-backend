package com.hostel.dto;

public class DashboardResponse {

    private long totalStudents;

    private long totalBlocks;

    private long totalFloors;

    private long totalRooms;

    private long totalBeds;

    private long availableBeds;

    private long allocatedBeds;

    private long activeAllocations;

    private double occupancyPercentage;

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public long getTotalBlocks() {
        return totalBlocks;
    }

    public void setTotalBlocks(long totalBlocks) {
        this.totalBlocks = totalBlocks;
    }

    public long getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(long totalFloors) {
        this.totalFloors = totalFloors;
    }

    public long getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(long totalRooms) {
        this.totalRooms = totalRooms;
    }

    public long getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(long totalBeds) {
        this.totalBeds = totalBeds;
    }

    public long getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(long availableBeds) {
        this.availableBeds = availableBeds;
    }

    public long getAllocatedBeds() {
        return allocatedBeds;
    }

    public void setAllocatedBeds(long allocatedBeds) {
        this.allocatedBeds = allocatedBeds;
    }

    public long getActiveAllocations() {
        return activeAllocations;
    }

    public void setActiveAllocations(long activeAllocations) {
        this.activeAllocations = activeAllocations;
    }

    public double getOccupancyPercentage() {
        return occupancyPercentage;
    }

    public void setOccupancyPercentage(double occupancyPercentage) {
        this.occupancyPercentage = occupancyPercentage;
    }
}