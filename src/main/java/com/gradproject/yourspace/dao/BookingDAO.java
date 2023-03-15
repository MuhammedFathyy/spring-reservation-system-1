package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Integer> {

    @Query(value = "SELECT user.email as userEmail , booking.start_time as startTime , booking.end_time as endTime, booking.date as bookingDate,  room.name as roomName , room.image as roomImage , room.price as roomPrice ,space.name as spaceName \n" +
            "from your_space.room , your_space.user, your_space.space, your_space.booking\n" +
            "where room.room_id = booking.room_id and space.space_id = room.space_id and user.user_id = booking.user_id  and user.user_id =:id",
            nativeQuery = true)
    List<BookingDTO> findAllByUserOrderByDate(int id);
}
