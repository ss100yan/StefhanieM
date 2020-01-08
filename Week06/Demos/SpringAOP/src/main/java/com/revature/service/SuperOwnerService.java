package com.revature.service;

import com.revature.model.SuperOwner;
import com.revature.repository.SuperOwnerRepository;
import com.revature.repository.SuperOwnerRepositoryImpl;

public class SuperOwnerService {

	private SuperOwnerRepository superOwnerRepository = new SuperOwnerRepositoryImpl();
	
	public void insertSuperOwner(SuperOwner so) {
		this.superOwnerRepository.insertSuperOwner(so);
	}
}
