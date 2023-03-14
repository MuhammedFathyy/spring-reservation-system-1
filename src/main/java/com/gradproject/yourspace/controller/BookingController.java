package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{bookId}")
    public Booking findById(@PathVariable int bookId) {
        return bookingService.findById(bookId);
    }

    @PostMapping()
    public void saveBooking(@RequestBody Booking booking) {
        booking.setId(0);
        bookingService.saveBooking(booking);
    }

    @PutMapping()
    public void updateBooking(@RequestBody Booking booking) {
        bookingService.updateBooking(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable int bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    @PatchMapping("/{id}")
    public void updateBookingPartially(@PathVariable int id, @RequestBody HashMap<String, Object> fields) {
        bookingService.updateBookingPartially(id, fields);
    }


}
