package com.gradproject.yourspace.dto;

import java.sql.Time;
import java.time.LocalDate;

public interface catyBookingDTO {
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