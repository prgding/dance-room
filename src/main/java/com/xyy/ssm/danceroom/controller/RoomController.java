package com.xyy.ssm.danceroom.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyy.ssm.danceroom.pojo.Room;
import com.xyy.ssm.danceroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping("/add")
    public int doAdd(@RequestBody Room room) {
        System.out.println(room);
        return roomService.addRoom(room);
    }

    @RequestMapping("/del/{id}")
    public int doDel(@PathVariable int id) {
        return roomService.deleteRoom(id);
    }


    @RequestMapping("/update")
    public int doUpdate(@RequestBody Room room) {
        System.out.println(room);
        return roomService.updateRoom(room);
    }


    @RequestMapping("/findOne/{id}")
    public String doFindOne(int id) throws JsonProcessingException {
        Room oneRoom = roomService.findOneRoom(id);
        return new ObjectMapper().writeValueAsString(oneRoom);
    }

    @RequestMapping(value = "/findAll", produces = "application/json;charset=utf-8")
    public String doFindAll() throws JsonProcessingException {
        List<Room> allRooms = roomService.findAllRooms();
        return new ObjectMapper().writeValueAsString(allRooms);
    }
}