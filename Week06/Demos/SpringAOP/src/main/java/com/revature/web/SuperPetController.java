package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.exception.NoSuchSuperPetException;
import com.revature.model.SuperJoke;
import com.revature.model.SuperPet;
import com.revature.service.SuperPetService;

/*
 * We're using Spring MVC, so we don't have to create our own servlets to handle
 * HTTP requests. The Dispatcher Servlet will simply consult the HandlerMapping
 * interface to determine which Spring controller should handle a request. That said,
 * let's turn this class into a Controller by using the @Controller stereotype.
 */

//@Controller(value="superPetController")
/*
 * @RestController is a more specific controller that writes to the response body. It
 * is actually a convenient way of specifying:
 * 
 * @Controller
 * @ResponseBody
 */
@RestController(value="superPetController")
/*
 * This provides a way of mapping this entire controller to a certain url pattern.
 */
@RequestMapping(value="/superpet")
public class SuperPetController {
	
	private SuperPetService superPetService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * We're using setter injection.
	 */
	@Autowired
	public void setSuperPetService(SuperPetService superPetService) {
		this.superPetService = superPetService;
	}
	
	/*
	 * The "value" here denotes that we must use the "/home" pattern to access the
	 * resource that this method returns. This means that in order to access this
	 * view, we should type: /superpet/home
	 * 
	 * We've also specified that the only acceptable method is "GET".
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index() {
		//This string refers to the name of a view we have created.
		return "index";
	}
	
	/*
	 * We can define what is referred to as an "Exception Handler" in Spring MVC.
	 * This allows us to define a method which handles a certain exception.
	 */
	
//	@ExceptionHandler(NoSuchSuperPetException.class)
//	public String noSuchSuperPet() {
//		return "You're a clown.";
//	}
	
	/*
	 * This is a more specific version @RequestMapping. It specifies that this endpoint
	 * only accepts GET requests. We have also specified that this endpoint should
	 * return JSON.
	 */
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	/*
	 * This annotation denotes that this method should write to the response body as
	 * the generic @Controller annotation does not write to the response body by 
	 * default. It attempts to resolve what you return as a view.
	 */
	@ResponseBody
	public List<SuperPet> getAllSuperPets(){
		return this.superPetService.getAllSuperPets();
	}
	
	@GetMapping(value="/one/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public SuperPet getSuperPetByName(@PathVariable String name) {
		
		return this.superPetService.getSuperPetByName(name);
	}
	
	/*
	 * Note that the PathVariable is simply appended to the url with a "/". We have
	 * an alternative to this PathVariable, which is the @RequestParam annotation.
	 * This instead allows us to take in a query string as a parameter in one of
	 * our methods.
	 */
	
	@GetMapping(value="/one/again", produces=MediaType.APPLICATION_JSON_VALUE)
	/*
	 * When using the @RequestParam annotation, be sure that the parameter names
	 * you append to the url match the RequestParam names specified in the method
	 * signature.
	 * 
	 * NOTE: We are now going to refactor this method to use a ResponseEntity instead.
	 * ResponseEntity contain what you will send back to the client (so the payload)
	 * as well as a status code.
	 */
	public ResponseEntity<SuperPet> getSuperPetByNameAgain(@RequestParam String name) throws NoSuchSuperPetException{
		
		SuperPet retrievedSuperPet = this.superPetService.getSuperPetByName(name);
		
		if(retrievedSuperPet == null) {
			throw new NoSuchSuperPetException();
		}
		
		else {
			return new ResponseEntity<>(retrievedSuperPet, HttpStatus.OK);
		}
	}
	
	/*
	 * We can use the @RequestBody annotation to grab information from the Request
	 * Body and immediately marshal it into a Java object. Note that this actually
	 * uses the Jackson ObjectMapper under the hood.
	 */
	@PostMapping(value="/new")
	public void postSuperPet(@RequestBody SuperPet superPet) {
		this.superPetService.insertSuperPet(superPet);
	}
	
	@GetMapping(value="/favoritejoke")
	public SuperJoke getSuperJoke(){
		SuperJoke retrievedJoke = this.restTemplate.getForObject(
				"http://api.icndb.com/jokes/random",
				SuperJoke.class);
		return retrievedJoke;
	}

}
