package com.revature.controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.revature.model.SuperOwner;
import com.revature.model.SuperPet;
import com.revature.service.SuperPetService;
import com.revature.web.SuperPetController;

/*
 * This tells Spring where to look for the mock application context. In this case,
 * we are using a dummy context we created.
 */
@ContextConfiguration(locations="classpath:testContext.xml")
/*
 * This denotes that our application context is a Web Application Context.
 */
@WebAppConfiguration

/*
 * When using JUnit, you can specify a test runner. This test runner is a class
 * that defines how your tests will be run. Spring has its own JUnit test runner,
 * which is called the SpringJUnit4ClassRunner. We can use the @RunWith annotation
 * to denote that we want the tests in this class to be run using a specific test
 * runner.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SuperPetControllerTest {

	@Autowired
	RestTemplate restTemplate;
	
	@Mock
	private SuperPetService superPetService;
	
	@InjectMocks
	private SuperPetController superPetController;
	
	/*
	 * Spring Mock MVC already has built-in support for mocking Spring controllers.
	 * We need only create a mock controller by using the MockMvc class.
	 */
	private MockMvc mockMvc;
	
	private SuperOwner superOwner;
	
	private List<SuperPet> superPets;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		//Now let's build our mock controller:
		mockMvc = MockMvcBuilders.standaloneSetup(superPetController).build();
		
		superPets = new ArrayList<>();
		
		superOwner = new SuperOwner(1, "Same Owner", "Some Land");
		superPets.add(new SuperPet(1, "Scooby Doo", "Brown with Spots", "Talking", 100, superOwner));
		superPets.add(new SuperPet(2, "Curtis's Pet Again", "Eh Cache", "Being Ambiguously Someone's Pet", 2, superOwner));
		superPets.add(new SuperPet(3, "Cute Cat", "Cute Color", "Commanding All Humans", 1000, superOwner));

	}
	
	@Test
	public void testGetAllSuperPets() {
		
		Mockito.when(superPetService.getAllSuperPets()).thenReturn(superPets);
		
		//Now let's actually test the controller:
		
		try {
			/*
			 * We are manually constructing a request and specifying what should happen
			 * when such a request is made.
			 */
			mockMvc.perform(get("/superpet/all").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print()).andReturn();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
