package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.entity.Booking;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

public interface BookingService {
    List<Booking> findAll();

    Booking findById(int bookId);

    ResponseEntity<String> saveBooking(Booking booking);

    ResponseEntity<String> updateBooking(Booking booking);

    ResponseEntity<String> deleteBooking(int bookingId);

    void updateBookingPartially(int id, HashMap<String, Object> fields);

    List<BookingDTO> getBookingsHistory(int userId);


}
