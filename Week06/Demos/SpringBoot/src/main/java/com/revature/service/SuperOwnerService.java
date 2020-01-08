package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.model.SuperOwner;
import com.revature.repository.SuperOwnerRepository;

@Service("superOwnerService")
public class SuperOwnerService {

	private SuperOwnerRepository superOwnerRepository;
	
	public void insertSuperOwner(SuperOwner so) {
		this.superOwnerRepository.save(so);
	}
}
