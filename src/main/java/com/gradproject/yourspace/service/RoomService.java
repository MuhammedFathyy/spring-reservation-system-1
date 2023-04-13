package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.RoomDAO;
import com.gradproject.yourspace.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    private final RoomDAO roomDAO;

    @Autowired

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }


    @Transactional
    public List<Room> getRooms() {
        return roomDAO.findAll();

    }

    @Transactional
    public Room getRoom(Integer id) {
        return roomDAO.getRoomByRoomId(id);
    }

    @Transactional
    public void saveRoom(Room room) {

        room.setRoomId(0);
        roomDAO.save(room);
    }

    @Transactional
    public void deleteRoom(Integer id) {
        roomDAO.deleteRoomByRoomId(id);
    }


    @Transactional
    public void updateRoomByField(Integer roomId, Map<String, Object> fields) {
        Room room = roomDAO.getRoomByRoomId(roomId);

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Room.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, room, value);

        });
        roomDAO.save(room);

    }

}

