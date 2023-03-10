package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.RoomDAO;
import com.gradproject.yourspace.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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


	@Transactional
    public void UpdateRoomByField(int roomId, Map<String, Object> fields) {
		roomDAO.UpdateRoomByField(roomId,fields);
    }
}
