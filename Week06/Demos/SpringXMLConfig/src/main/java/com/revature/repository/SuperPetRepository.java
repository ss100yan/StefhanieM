package com.revature.repository;

import java.util.List;

import com.revature.model.SuperPet;

public interface SuperPetRepository {

	void insertSuperPet(SuperPet s);
	List<SuperPet> getAllSuperPets();
	SuperPet getSuperPetByName(String name);
	/*
	 * Please attempt to implement these
	 * two methods.
	 */
	void deleteSuperPet(SuperPet s);
	void updateSuperPet(SuperPet s);
	
}
