package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.BookingDAO;
import com.gradproject.yourspace.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingDAO bookingDAO;

    public BookingServiceImpl(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    @Transactional
    public List<Booking> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    @Transactional
    public Optional<Booking> findById(int bookId) {
        return bookingDAO.findById(
                Integer.valueOf(bookId)
        );
    }

    @Override
    @Transactional
    public void saveBooking(Booking booking) {
        bookingDAO.save(booking);
    }

    @Override
    @Transactional
    public void updateBooking(Booking booking) {
                bookingDAO.save(booking);
    }

    @Override
    @Transactional
    public void deleteBooking(int bookingId) {
        bookingDAO.delete(bookingDAO.findById(
                Integer.valueOf(bookingId)
        ).get());
    }
}
