package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.revature.model.Superowner;
import com.revature.model.Superpet;

@Repository("superPetRepository")
public class SuperPetRepository {

	private static final List<Superpet> superPets = new ArrayList<>();
	private static final Superowner owner = new Superowner(1, "Owner of Talking Dogs", "TV");
	
	@PostConstruct
	public void initData() {
		Superpet scooby = new Superpet(1, "Scooby", "Brown", "Talking Dog", 2, owner);
		Superpet courage = new Superpet(2, "Courage", "Purple", "Talking Dog", 1, owner);
		Superpet scrappy = new Superpet(3, "Scrappy", "Brown As Well, but Smaller", "Annoying Talking Dog", -100, owner);
		
		superPets.add(scooby);
		superPets.add(courage);
		superPets.add(scrappy);
	}
	
	public Superpet findSuperpetByName(String name) {
		Superpet pet = null;
		
		for(Superpet p : superPets) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return pet;
	}
}
