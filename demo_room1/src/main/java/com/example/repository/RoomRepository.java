package com.example.repository; //for storing data into database, about the room information 

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

//    Optional<Room> findByroomName(String roomName); //find room

}
