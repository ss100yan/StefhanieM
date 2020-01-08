package com.revature.service;

import java.util.List;

import com.revature.model.SuperPet;
import com.revature.repository.SuperPetRepository;
import com.revature.repository.SuperPetRepositoryImpl;

public class SuperPetService {

	SuperPetRepository sp = new SuperPetRepositoryImpl();
	
	public void insertSuperPet(SuperPet s) {
		this.sp.insertSuperPet(s);
	}
	
	public List<SuperPet> getAllSuperPets(){
		return this.sp.getAllSuperPets();
	}
	
	public SuperPet getSuperPetByName(String name) {
		return this.sp.getSuperPetByName(name);
	}
}
