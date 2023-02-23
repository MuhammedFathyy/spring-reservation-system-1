package com.gradproject.yourspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradproject.yourspace.entity.Room;
import com.gradproject.yourspace.service.RoomService;

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

	@PutMapping()
	public Room updateRoom(@RequestBody Room room) {
		roomService.saveRoom(room);
		return room;
	}

	@DeleteMapping("{roomId}")
	public String deleteRoom(@PathVariable int roomId) {
		roomService.deleteRoom(roomId);
		return "Successfully deleted";
	}
}
