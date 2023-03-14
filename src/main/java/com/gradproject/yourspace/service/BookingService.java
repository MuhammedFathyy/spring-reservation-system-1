package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findAll();

    Optional<Booking> findById(int bookId);

    void saveBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(int bookingId);
}
