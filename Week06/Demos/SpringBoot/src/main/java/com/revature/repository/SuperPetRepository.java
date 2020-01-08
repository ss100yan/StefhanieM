package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.SuperPet;

/*
 * Spring Data JPA gives us access to pre-implemented persistence methods. It does so
 * by allowing us to use the Java Persistence API's JPARepository.
 * 
 * The JPARepository extends a repository (which is an interface) known as the
 * CRUDRepository. It is designed to wrap around an ORM framework (Hibernate in our
 * case) and implement methods in our repository layer under the hood. We need only
 * create an interface and extend the JPARepository.
 * 
 * Note that the JPARepository takes generics. The first denotes the entity which we
 * will be working with. The second denotes the type of the unique identifier (which
 * will be Integer in our case).
 */

@Repository("superPetRepository")
public interface SuperPetRepository extends JpaRepository<SuperPet, Integer>{

	public List<SuperPet> findAll();
	
	/*
	 * We can use the @Query annotation if we want to create more custom queries which
	 * extend the default behavior of the JpaRepository.
	 * 
	 * As a general note, ?1 is a parameterized representation of the first parameter
	 * in the method. If there were 2 parameters, we would use ?2.
	 */
	@Query("from SuperPet where power = ?1 order by age")
	List<SuperPet> findAllByPower(String power);
	//For compound queries (e.g. AND, etc.)
	List<SuperPet> findAllByNameAndPower(String name, String power);
	SuperPet findByName(String name);
	SuperPet findByPower(String power);
	SuperPet findByAge(int id);
	<S extends SuperPet> S save(SuperPet s);
	
}
