package com.xyy.ssm.danceroom.pojo;

public class Room {
    int id;
    String name;
    int area;
    int status;

    public Room() {
    }
    public Room(String name, int area, int status) {
        this.name = name;
        this.area = area;
        this.status = status;
    }

    public Room(int id, String name, int area, int status) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", status=" + status +
                '}';
    }
}
