package com.xyy.ssm.danceroom.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyy.ssm.danceroom.pojo.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")
public class RoomMapperTest {
    @Autowired
    private RoomMapper roomMapper;

    @Test
    public void insert() {
        roomMapper.insert(new Room("test", 100, 0));
    }

    @Test
    public void delete() {
        roomMapper.delete(3);
    }

    @Test
    public void update() {
        roomMapper.update(new Room(2, "1楼102", 35, 1));
    }

    @Test
    public void findOne() throws JsonProcessingException {
        Room one = roomMapper.findOne(2);
        ObjectMapper json = new ObjectMapper();
        String s = json.writeValueAsString(one);
        System.out.println(s);
        System.out.println(one);
    }

    @Test
    public void findAll() throws JsonProcessingException {
        List<Room> all = roomMapper.findAll();
        ObjectMapper json = new ObjectMapper();
        String all_str = json.writeValueAsString(all);
        System.out.println(all_str);
    }
}