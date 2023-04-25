package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private BookingService bookingService;
    private ModelMapper modelMapper;

    public BookingController(BookingService bookingService, ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<BookingDTO> findAll() {
        return bookingService.findAll()
                .stream()
                .map(booking -> modelMapper.map(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    public BookingDTO findById(@PathVariable int bookId) {
        Booking booking = bookingService.findById(bookId);
        return modelMapper.map(booking, BookingDTO.class);
    }

    @PostMapping()
    public ResponseEntity<String> saveBooking(@RequestBody @Valid BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        return bookingService.saveBooking(booking);
    }


    @PutMapping()
    public ResponseEntity<String> updateBooking(@RequestBody @Valid BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
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
    // TODO: mod and push
    public List<BookingDTO> getBookingsHistory(@PathVariable int userId) {
        return bookingService.getBookingsHistory(userId);
    }


}
