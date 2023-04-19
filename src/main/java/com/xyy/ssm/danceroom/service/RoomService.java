package com.xyy.ssm.danceroom.service;

import com.xyy.ssm.danceroom.pojo.Room;

import java.util.List;

public interface RoomService {
    int addRoom(Room room);
    int deleteRoom(int id);
    int updateRoom(Room room);
    Room findOneRoom(int id);
    List<Room> findAllRooms();
    
}
