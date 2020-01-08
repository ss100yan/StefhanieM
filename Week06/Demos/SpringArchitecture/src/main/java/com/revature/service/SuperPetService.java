package com.revature.service;

import java.util.List;

import com.revature.model.SuperPet;
import com.revature.repository.SuperPetRepository;
import com.revature.repository.SuperPetRepositoryImpl;

public class SuperPetService {

	/*
	 * The SuperPetService class has a SuperPetRepositoryImpl as a dependency.
	 * This is an example of tight coupling as I would have to change this class's
	 * implementation if I were to ever change the SuperPetRepositoryImpl's
	 * implementation.
	 */
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
