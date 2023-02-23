package com.gradproject.yourspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gradproject.yourspace.dao.RoomDAO;
import com.gradproject.yourspace.entity.Room;

@Service
public class RoomService {

	@Autowired
	private RoomDAO roomDAO;

	public RoomService(RoomDAO roomDAO) {
		super();
		this.roomDAO = roomDAO;
	}
	@Transactional
	public List<Room> getRooms() {
		return roomDAO.getRooms();

	}
	
	@Transactional
	public Room getRoom(int id) {
		return roomDAO.getRoom(id);
	}
	
	@Transactional
	public void saveRoom(Room room) {
		roomDAO.saveRoom(room);
	}

	@Transactional
	public void deleteRoom(int id)
	{
		roomDAO.deleteRoom(id);
	}

}
