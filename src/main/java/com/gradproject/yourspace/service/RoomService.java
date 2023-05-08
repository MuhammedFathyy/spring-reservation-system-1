package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.BookingDAO;
import com.gradproject.yourspace.dao.RoomDAO;
import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.entity.Room;
import com.gradproject.yourspace.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    private final RoomDAO roomDAO;
    private final BookingDAO bookingDAO;


    public RoomService(RoomDAO roomDAO, BookingDAO bookingDAO) {
        this.roomDAO = roomDAO;
        this.bookingDAO = bookingDAO;
    }

    @Transactional
    public List<Room> getRooms() {
        return roomDAO.findAll();

    }

    @Transactional
    public Room getRoom(Integer id) {

        return roomDAO.findById(
                Integer.valueOf(id)
        ).orElseThrow(() -> new BadRequestException("Entity not found"));

    }

    @Transactional
    public ResponseEntity<String> saveRoom(Room room) {
        room.setRoomId(0);
        roomDAO.save(room);
        return ResponseEntity.ok("");
    }

    @Transactional
    public ResponseEntity <String> deleteRoom(Integer id) {
        roomDAO.deleteRoomByRoomId(id);
        return ResponseEntity.ok("");
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

    @Transactional
    public List<Room> getRoomBySpace (int spaceId)
    {
        return roomDAO.findRoomBySpaceId(spaceId);
    }

    @Transactional
    public Room getRoomByBooking (int bookingId)
    {
        return roomDAO.findRoomByBooking(bookingId);
    }
    public boolean isRoomAvailable(Integer roomId, LocalDate date, Time startTime,
                                   Time endTime) {
        roomDAO.findById(roomId).orElse(null);
        List<Booking> bookings = bookingDAO.findBookingsByRoomAndDate(roomId, date);
        for (Booking booking : bookings) {
            if (startTime.after(booking.getEndTime()) || startTime.equals(booking.getEndTime())) {
            } else if (endTime.before(booking.getStartTime()) || endTime.equals(booking.getStartTime())) {
            } else return false;
        }
        return true;
    }

}

