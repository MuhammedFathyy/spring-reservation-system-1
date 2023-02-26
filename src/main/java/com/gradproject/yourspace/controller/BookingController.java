package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/booking/{bookId}")
    public Booking findById(@PathVariable int bookId) {
        return bookingService.findById(bookId);
    }

    @PostMapping("/bookings")
    public void saveBooking(@RequestBody Booking booking) {
        booking.setId(0);
        bookingService.saveBooking(booking);
    }

    @PutMapping("/bookings")
    public void updateBooking(@RequestBody Booking booking) {
        bookingService.updateBooking(booking);
    }

    @DeleteMapping("/booking/{bookingId}")
    public void deleteBooking(@PathVariable int bookingId) {
        Booking temp = bookingService.findById(bookingId);
        if (temp == null) throw new RuntimeException("no booking with id "+ bookingId);
        bookingService.deleteBooking(bookingId);
    }
}
