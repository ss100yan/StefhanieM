package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.SuperOwner;

@Repository("superOwnerRepository")
public interface SuperOwnerRepository extends JpaRepository<SuperOwner, Integer>{

	<S extends SuperOwner> S save(SuperOwner s);
}
