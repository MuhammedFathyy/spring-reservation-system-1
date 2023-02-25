package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();

    Booking findById(int bookId);

    void saveBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(int bookingId);
}
