package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Booking;
import com.example.model.Room;
import com.example.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
    	this.bookingService = bookingService;
    }
    
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {//get the submit form data from frontEnd
        Room room = new Room();
        room.setId(bookingRequest.getRoomId());

        try {
            //try to create a booking
            Booking booking = bookingService.makeBooking(
                room,
                bookingRequest.getGuestFullName(),
                bookingRequest.getGuestEmail(),
                bookingRequest.getDescription(),
                bookingRequest.getStartTime(),
                bookingRequest.getEndTime()
            );

            // if created successfully
            return new ResponseEntity<>(booking, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            // 400 Bad Request
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        } catch (IllegalStateException e) {
            //409 Conflict
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);

        } catch (Exception e) {
            //500 Internal Server Error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}