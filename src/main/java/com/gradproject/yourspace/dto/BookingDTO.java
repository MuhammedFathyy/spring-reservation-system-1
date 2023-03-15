package com.gradproject.yourspace.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.util.Date;

public interface BookingDTO {
    String getUserFirstName();

    String getUserLastName();

    Time getStartTime();

    Time getEndTime();

    Date getBookingDate();

    String getRoomName();

    String getRoomImage();

    float getRoomPrice();

    String getSpaceName();

    String getSpaceAddress();
}