package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;

public class BookingDTO {
    private int id;
    @NotNull
    private Time startTime;
    @NotNull
    private Time endTime;
    @NotNull
    private LocalDate date;
    @NotNull
    private Integer roomId;
    @NotNull
    private Integer userId;
}
