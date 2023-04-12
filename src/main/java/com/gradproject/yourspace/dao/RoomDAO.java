package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomDAO extends JpaRepository <Room , Integer> {

	public List<Room> findAll ();

	public Room getRoomByRoomId(Integer id);

	public void deleteRoomByRoomId(Integer id);



}





