package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.revature.model.GetSuperPetRequest;
import com.revature.model.GetSuperPetResponse;
import com.revature.repository.SuperPetRepository;

@Endpoint("superPetService")
public class SuperPetService {

	private static final String NAMESPACE_URI = "http://www.example.org/superpet";
	
	private SuperPetRepository superPetRepository;
	
	@Autowired
	public SuperPetService(SuperPetRepository superPetRepository) {
		this.superPetRepository = superPetRepository;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getSuperPetRequest")
	@ResponsePayload
	public GetSuperPetResponse getSuperpet(@RequestPayload GetSuperPetRequest request) {
		
		GetSuperPetResponse response = new GetSuperPetResponse();
		response.setSuperpet(superPetRepository.findSuperpetByName(request.getName()));
		return response;
	}
}
