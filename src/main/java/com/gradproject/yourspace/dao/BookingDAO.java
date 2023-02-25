package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Booking;

import java.util.List;

public interface BookingDAO {
    List<Booking> findAll();

    Booking findById(int bookId);

    void saveBooking(Booking booking);

    void deleteBooking(int bookingId);
}
