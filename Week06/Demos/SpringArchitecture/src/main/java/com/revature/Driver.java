package com.revature;

import com.revature.service.SuperPetService;

public class Driver {

	public static void main(String[] args) {
		
		//In this layer of the application, we have a SuperPetService dependency. Again,
		//this layer of the application depends on SuperPetService's implementation.
		SuperPetService sps = new SuperPetService();
		
		System.out.println(sps.getAllSuperPets());
		
		
	}
}
