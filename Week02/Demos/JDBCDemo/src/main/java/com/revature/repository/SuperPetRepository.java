package com.revature.repository;

import java.util.List;

import com.revature.model.SuperPet;

/*
 * Your repository layer serves as your data layer. This is the layer of
 * your application which should directly interact with your database. In
 * other words, we're separating our concerns.
 * 
 * We will use this interface to define methods that must be implemented
 * by classes which interact with our database.
 */
public interface SuperPetRepository {

	List<SuperPet> getAllSuperPets();
	SuperPet getSuperPetById(int id);
	void insertSuperPet(SuperPet superPet);
	void updateSuperPetById(int id);
	void deleteSuperPetById(int id);
}
