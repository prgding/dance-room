package com.xyy.ssm.danceroom.mapper;

import com.xyy.ssm.danceroom.pojo.Room;

import java.util.List;

public interface RoomMapper {
    int insert(Room room);
    int delete(int id);
    int update(Room room);
    Room findOne(int id);
    List<Room> findAll();
}
