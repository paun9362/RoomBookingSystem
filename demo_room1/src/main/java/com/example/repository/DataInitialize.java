package com.example.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.Room;

@Configuration
public class DataInitialize {

    @Bean
    public CommandLineRunner initializeData(RoomRepository roomRepository) { //fail to initialize the data
        return (args) -> {
            roomRepository.deleteAll();

            roomRepository.save(new Room(null, "Big", null));
            roomRepository.save(new Room(null, "Big",  null));
            roomRepository.save(new Room(null, "Medium", null));
            roomRepository.save(new Room(null, "Medium",  null));
            roomRepository.save(new Room(null, "Small", null));
            roomRepository.save(new Room(null, "Small",  null));
            roomRepository.save(new Room(null, "Small",  null));
            roomRepository.save(new Room(null, "Small",  null));
            roomRepository.save(new Room(null, "Small",  null));
            roomRepository.save(new Room(null, "Small",  null));
            roomRepository.save(new Room(null, "Small",  null));
            roomRepository.save(new Room(null, "Small",  null));
        };
    }
}