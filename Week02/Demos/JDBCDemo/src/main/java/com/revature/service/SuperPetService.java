package com.revature.service;

import java.util.List;

import com.revature.model.SuperPet;
import com.revature.repository.SuperPetRepository;
import com.revature.repository.SuperPetRepositoryImpl;

/*
 * This is our service layer. This is where we should place our business logic.
 * For instance, if we wish to mutate our data in any particular way, this is
 * where we should do that.
 */
public class SuperPetService {

	private SuperPetRepository superPetRepository = new SuperPetRepositoryImpl();
	
	public List<SuperPet> getAllSuperPets(){
		return this.superPetRepository.getAllSuperPets();
	}
	
	public SuperPet getSuperPetById(int id) {
		return this.superPetRepository.getSuperPetById(id);
	}
	
	public void insertSuperPet(SuperPet superPet) {
		this.superPetRepository.insertSuperPet(superPet);
	}
}
