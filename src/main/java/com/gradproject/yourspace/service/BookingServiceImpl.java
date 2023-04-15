package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.BookingDAO;
import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.entity.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingDAO bookingDAO;
    private final RoomService roomService;

    public BookingServiceImpl(BookingDAO bookingDAO, RoomService roomService) {
        this.bookingDAO = bookingDAO;
        this.roomService = roomService;
    }

    @Override
    @Transactional
    public List<Booking> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    @Transactional
    public Booking findById(int bookId) {
        return bookingDAO.findById(
                Integer.valueOf(bookId)
        ).get();
    }

    @Override
    @Transactional
    public ResponseEntity<String> saveBooking(Booking booking) {
        booking.setId(0);
        if (!roomService.isRoomAvailable(
                booking.getRoom().getRoomId(),
                booking.getDate(),
                booking.getStartTime(),
                booking.getEndTime()
        )) return ResponseEntity.badRequest().body("There is Conflict with another" +
                " Booking");
        bookingDAO.save(booking);
        return ResponseEntity.ok("");
        //generate Qr Code
        //send mail

    }

    @Override
    @Transactional
    public ResponseEntity<String> updateBooking(Booking booking) {
        if (!roomService.isRoomAvailable(
                booking.getRoom().getRoomId(),
                booking.getDate(),
                booking.getStartTime(),
                booking.getEndTime()
        )) return ResponseEntity.badRequest().body("There is Conflict with another" +
                " Booking");
        bookingDAO.save(booking);
        return ResponseEntity.ok("");
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteBooking(int bookingId) {
        Booking booking = bookingDAO.findById(bookingId).orElse(null);
        if (booking == null)
            return ResponseEntity.badRequest()
                    .body("booking with id " + bookingId + " doesn't exist");

        LocalDate bookingDate = booking.getDate();
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), bookingDate);
        if (daysBetween <= 1) {
            throw new RuntimeException("can't cancel booking with id " + bookingId);
        }
        bookingDAO.delete(booking);
        return ResponseEntity.ok("Booking canceled");
    }


    @Override
    public void updateBookingPartially(int id, HashMap<String, Object> fields) {
        Booking booking = bookingDAO.findById(id).orElse(null);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Booking.class, key);
            field.setAccessible(true);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            boolean flag = true;
            try {
                LocalDate date = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, booking, date);
                flag = false;
            } catch (DateTimeParseException e) {
                try {
                    ReflectionUtils.setField(field, booking, Time.valueOf((String) value));
                    flag = false;
                } catch (Exception ex) {
                }
            }

            if (flag)
                ReflectionUtils.setField(field, booking, value);
        });
        bookingDAO.save(booking);
    }

    @Override
    @Transactional
    public List<BookingDTO> getBookingsHistory(int userId) {
        return bookingDAO.findAllByUserOrderByDate(userId);

    }


}
