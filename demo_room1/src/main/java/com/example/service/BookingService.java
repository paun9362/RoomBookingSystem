package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Admin;
import com.example.model.Booking;
import com.example.model.Room;
import com.example.model.User;
import com.example.repository.BookingRepository;
import com.example.repository.RoomRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
	
    private BookingRepository bookingRepository;
    private RoomRepository roomRepository;

    
    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }
    public Booking makeBooking(Room room,String guestFullName, String guestEmail,String description, LocalDateTime startTime, LocalDateTime endTime) {
    	Booking roomBooking = new Booking();
    	
    	roomBooking.setGuestFullName(guestFullName);
    	roomBooking.setGuestEmail(guestEmail);
    	roomBooking.setDescription(description);
    	roomBooking.setStartTime(startTime);
    	roomBooking.setEndTime(endTime);
    	roomBooking.setRoom(room);
    	
    	return saveBooking(roomBooking);
    }
    
    @Transactional
    public Booking saveBooking(Booking booking) { // save booking into database && validate the data //havn't perform validation on timeSlot
    	
    	Room room = booking.getRoom();
    	
    	//check if the room information is correct
    	if(room==null||room.getId()==null){
            throw new IllegalArgumentException("Room Information is invalid!");
    	}
    	//check if the room is already on booked
    	//check if the room is inside the booking entity
    	Optional<Booking> existBooking = bookingRepository.findByRoomId(room.getId());
    	if (existBooking.isPresent()) {
            throw new IllegalStateException("Room is already booked");
		}
    		
    	
    	return bookingRepository.save(booking);
    }
    
    public void deleteBooking(Long bookingId, User currentUser) { //bookingId is primary key
    	if(currentUser instanceof Admin) { //currentUser.getIsAdmin()
    		
    		try {
    			Optional<Booking> bookingDeleting = bookingRepository.findById(bookingId); //get the targeted booking record
	    		if(bookingDeleting.isPresent()) {
	    			Booking booking = bookingDeleting.get(); //retrieve the booking
	    			bookingRepository.delete(booking);
	    		}
    		}
    		catch(Exception e){
                throw new RuntimeException("Error occurred while deleting the booking ", e);
    		}

    	}
    	
    }
}
