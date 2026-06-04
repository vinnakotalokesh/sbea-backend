package com.hostel.service;

import com.hostel.entity.Room;
import com.hostel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public Room saveRoom(Room room){
        return repository.save(room);
    }

    public List<Room> getAllRooms(){
        return repository.findAll();
    }

    public List<Room> getRoomsByFloor(
            Long floorId){

        return repository.findByFloorId(
                floorId);
    }

    public void deleteRoom(Long id){
        repository.deleteById(id);
    }

    public Room updateRoom(
            Long id,
            Room room){

        Room existing =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Room Not Found"));

        existing.setRoomNumber(
                room.getRoomNumber());

        existing.setRoomType(
                room.getRoomType());

        return repository.save(existing);
    }
}