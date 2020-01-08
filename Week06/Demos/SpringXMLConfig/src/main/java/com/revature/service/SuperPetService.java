package com.revature.service;

import java.util.List;

import com.revature.model.SuperPet;
import com.revature.repository.SuperPetRepository;
import com.revature.repository.SuperPetRepositoryImpl;

public class SuperPetService {

	/*
	 * The SuperPetService class has a SuperPetRepositoryImpl as a dependency.
	 * Now, however, we will rely on the framework to provide an instance of the
	 * dependency when it is needed.
	 * 
	 * That said, Spring still needs to know how to inject the dependency. So are
	 * we using setter injection, constructor injection, or field injection?
	 * 
	 * Setter injection entails injecting a dependency via a bean's setter.
	 * 
	 * Constructor injection entails injecting a dependency via a bean's constructor.
	 * 
	 * Field injection entails injecting a dependency via a bean's field.
	 */
	
	SuperPetRepository superPetRepository;
	
	//Using Constructor injection instead.
	public SuperPetService(SuperPetRepository superPetRepository) {
		this.superPetRepository = superPetRepository;
	}
	
	/*
	 * We want to use setter injection, which means that there must be a setter here.
	 */
	public void setSuperPetRepository(SuperPetRepository superPetRepository) {
		this.superPetRepository = superPetRepository;
	}
	
	public void insertSuperPet(SuperPet s) {
		this.superPetRepository.insertSuperPet(s);
	}
	
	public List<SuperPet> getAllSuperPets(){
		return this.superPetRepository.getAllSuperPets();
	}
	
	public SuperPet getSuperPetByName(String name) {
		return this.superPetRepository.getSuperPetByName(name);
	}
}
