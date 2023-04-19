package com.xyy.ssm.danceroom.service.impl;

import com.xyy.ssm.danceroom.mapper.RoomMapper;
import com.xyy.ssm.danceroom.pojo.Room;
import com.xyy.ssm.danceroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public int addRoom(Room room) {
        return roomMapper.insert(room);
    }

    @Override
    public int deleteRoom(int id) {
        return roomMapper.delete(id);
    }

    @Override
    public int updateRoom(Room room) {
        return roomMapper.update(room);
    }

    @Override
    public Room findOneRoom(int id) {
        return roomMapper.findOne(id);
    }

    @Override
    public List<Room> findAllRooms() {
        return roomMapper.findAll();
    }
}
