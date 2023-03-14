package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.entity.Room;
import com.gradproject.yourspace.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        super();
        this.roomService = roomService;
    }

    @GetMapping("allrooms")
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("{roomId}")
    public Room getRoom(@PathVariable int roomId) {
        return roomService.getRoom(roomId);
    }

    @PostMapping()
    public Room addRoom(@RequestBody Room room) {
        room.setRoomId(0);
        roomService.saveRoom(room);
        return room;
    }

    @PatchMapping("{roomId}")
    public void updateRoom(@PathVariable Integer roomId, @RequestBody HashMap<String, Object> fields) {
        roomService.updateRoomByField(roomId, fields);
    }

    @DeleteMapping("{roomId}")
    public String deleteRoom(@PathVariable int roomId) {
        roomService.deleteRoom(roomId);
        return "Successfully deleted";
    }

    @GetMapping("roomBookings/{roomId}")
    public List<Booking> getBookings(@PathVariable int roomId) {
        Room room = roomService.getRoom(roomId);
        return room.getBookings();
    }


}
