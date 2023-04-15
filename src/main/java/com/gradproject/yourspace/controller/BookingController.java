package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<String> saveBooking(@RequestBody @Valid Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping()
    public ResponseEntity<String> updateBooking(@RequestBody @Valid Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable int bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    @PatchMapping("/{id}")
    public void updateBookingPartially(@PathVariable int id, @RequestBody HashMap<String, Object> fields) {
        bookingService.updateBookingPartially(id, fields);
    }

    @GetMapping("bookingsHistory/{userId}")
    public List<BookingDTO> getBookingsHistory(@PathVariable int userId) {
        return bookingService.getBookingsHistory(userId);
    }


}
