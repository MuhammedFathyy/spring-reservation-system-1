package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomDAO extends JpaRepository <Room , Integer> {

	public List<Room> findAll ();

	public Room getRoomByRoomId(Integer id);

	public void deleteRoomByRoomId(Integer id);


	@Query(value = "select * from room r where r.space_id = :spaceId" , nativeQuery = true)
	public List<Room> findRoomBySpaceId (Integer spaceId);

	@Query(value = "select * from room , booking " +
			"where room.room_id = booking.room_id and booking.book_id = :bookingId ", nativeQuery = true)
	public Room findRoomByBooking (Integer bookingId);
}





