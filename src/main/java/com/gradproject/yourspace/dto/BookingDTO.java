package com.gradproject.yourspace.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public interface BookingDTO {
    String getUserFirstName();

    String getUserLastName();

    Time getStartTime();

    Time getEndTime();

    LocalDate getBookingDate();

    String getRoomName();

    String getRoomImage();

    float getRoomPrice();

    String getSpaceName();

    String getSpaceAddress();
}