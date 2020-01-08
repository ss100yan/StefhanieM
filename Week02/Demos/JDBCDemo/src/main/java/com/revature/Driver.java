package com.revature;

import java.util.Scanner;

import com.revature.service.SuperPetService;

public class Driver {
		
	public static void main(String[] args) {
		
		SuperPetService superPetService = new SuperPetService();
		
		System.out.println(superPetService.getAllSuperPets());
		
//		
//		System.out.println(superPetService.getSuperPetById(3));
//		
//		SuperPet superPet = new SuperPet(18, "Greatest SuperPet", "Power?", "Color?", 67, "Greatest SuperOwner");
//		
//		superPetService.insertSuperPet(superPet);
	}
}
