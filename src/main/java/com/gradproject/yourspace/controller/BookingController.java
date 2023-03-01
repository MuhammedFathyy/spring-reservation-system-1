package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @PatchMapping("bookings/{id}")
    public void updateBookingPartially(@PathVariable int id, @RequestBody HashMap<String, Object> fields) {
        Booking booking = bookingService.findById(id);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Booking.class, key);
            field.setAccessible(true);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            boolean flag = true;
            try {
                Date date = dateFormat.parse((String) value);
                ReflectionUtils.setField(field, booking, date);
                flag = false;
            } catch (ParseException e) {
                try {
                    ReflectionUtils.setField(field, booking, Time.valueOf((String) value));
                    flag = false;
                } catch (Exception ex) {
                }
            }

            if (flag)
                ReflectionUtils.setField(field, booking, value);
        });
        bookingService.updateBooking(booking);
    }













}
