package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name ="room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Room {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String roomType;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL) //when room deleted, then booking history deleted too
	private List<Booking> bookings; //booking history
	
	
}
