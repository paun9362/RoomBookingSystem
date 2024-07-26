package com.example.model;


public class Admin extends User {
	
	public Admin(Long id, String userName, String password, String adminSpecificField) {
        super(id, userName, password, true);
    }
	
}
