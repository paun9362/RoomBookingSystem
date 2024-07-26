package com.example.controller;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookingRequest {
    private Long roomId;
    private String guestFullName;
    private String guestEmail;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

   
}