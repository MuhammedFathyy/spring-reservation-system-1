package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.dto.RoomDTO;
import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.entity.Room;
import com.gradproject.yourspace.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    private ModelMapper modelMapper;


    public RoomController(RoomService roomService, ModelMapper modelMapper) {
        this.roomService = roomService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("allrooms")
    public List<RoomDTO> getRooms() {

        return roomService.getRooms()
                .stream()
                .map(room -> modelMapper.map(room, RoomDTO.class))
                .collect(Collectors.toList());

    }

    @GetMapping("{roomId}")
    public RoomDTO getRoom(@PathVariable int roomId) {
        Room room = roomService.getRoom(roomId);
        return modelMapper.map(room , RoomDTO.class);
    }

    @PostMapping()
    public ResponseEntity<String> addRoom(@RequestBody @Valid RoomDTO roomDTO) {
        Room room = modelMapper.map(roomDTO, Room.class);
        return roomService.saveRoom(room);
    }

    @DeleteMapping("{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable int roomId) {
        return roomService.deleteRoom(roomId);
    }

    @PatchMapping("/{roomId}")
    public void updateRoomPartially(@PathVariable int roomId, @RequestBody HashMap<String, Object> fields) {
        roomService.updateRoomByField(roomId, fields);
    }
    @GetMapping("roomBookings/{roomId}")
    public List<Booking> getBookings(@PathVariable int roomId) {
        Room room = roomService.getRoom(roomId);
        return room.getBookings();
    }


}
