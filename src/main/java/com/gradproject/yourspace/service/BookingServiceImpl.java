package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.BookingDAO;
import com.gradproject.yourspace.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingDAO bookingDAO;
    @Override
    @Transactional
    public List<Booking> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    @Transactional
    public Booking findById(int bookId) {
        return bookingDAO.findById(bookId);
    }

    @Override
    @Transactional
    public void saveBooking(Booking booking) {
        booking.setId(0);
        bookingDAO.saveBooking(booking);
    }

    @Override
    @Transactional
    public void updateBooking(Booking booking) {
        bookingDAO.saveBooking(booking);
    }

    @Override
    @Transactional
    public void deleteBooking(int bookingId) {
        bookingDAO.deleteBooking(bookingId);
    }
}
