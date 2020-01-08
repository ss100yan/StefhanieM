package com.revature.servicetests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.model.SuperPet;
import com.revature.repository.SuperPetRepositoryImpl;
import com.revature.service.SuperPetService;

/*
 * Mocking is a mocking framework that is used to mock our dependencies. Recall
 * that a unit test is a test that tests a component without its dependencies.
 * For instance, our service layer has a repository object as a dependency.
 * We want to mock out this repository dependency in order to truly test
 * our service layer.
 */
public class SuperPetServiceTests {

	//This is the dependency which we want to mock out.
	/*
	 * This annotation denotes that we want Mockito to mock this dependency
	 * for us.
	 */
	@Mock
	public SuperPetRepositoryImpl superPetRepositoryImpl;
	
	//This is what we want to test
	/*
	 * This tells Mockito to inject our mocks (so anything annotated with
	 * @Mock) into this object.
	 */
	@InjectMocks
	public static SuperPetService superPetService;
	
	@BeforeClass
	public static void setUp() {
		superPetService = new SuperPetService();
	}
	
	@Before
	public void beforeEach() {
		/*
		 * We must initialize anything that has been annotated with our
		 * Mockito annotations.
		 */
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllSuperPets() {
		
		/*
		 * I need to supply some mock data that will be returned whenever we
		 * call the getAllSuperPets method. This ensures that I never hit my
		 * database just to test my service layer.
		 */
		
		Mockito.when(superPetRepositoryImpl.getAllSuperPets()).thenReturn(
				Arrays.asList(
						new SuperPet(1, "Name", "Color", "Power", 32, "Owner"),
						new SuperPet(2, "Name2", "Color2", "Power2", 329, "Owner2"),
						new SuperPet(3, "Name3", "Color3", "Power3", 3200, "Owner3")
						)
				);
		
		Assert.assertNotNull(SuperPetServiceTests.superPetService.getAllSuperPets());
		Assert.assertEquals(SuperPetServiceTests.superPetService
				.getAllSuperPets()
				 .get(0).getName(), "Name");
	}
}
