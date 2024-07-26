package com.example.repository; 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {
   Optional <Booking> findByRoomId(Long roomId);  //use optional to find the "roomId" to avoid null error
}