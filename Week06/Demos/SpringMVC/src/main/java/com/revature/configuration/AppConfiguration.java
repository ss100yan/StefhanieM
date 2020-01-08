package com.revature.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.revature.repository.SuperPetRepository;
import com.revature.repository.SuperPetRepositoryImpl;

/*
 * The Configuration annotation denotes that this class should be used to generate
 * Spring beans and requests for those beans.
 */
@Configuration
public class AppConfiguration {

	/*
	 * A Configuration class contains methods which return Spring beans. Those beans
	 * are then added to your IOC container.
	 */
	@Bean(name="superPetRepository2")
	@Scope(scopeName="singleton")
	public SuperPetRepository getSuperPetRepository() {
		return new SuperPetRepositoryImpl();
	}
	
	//Let's first add a RestTemplate bean to our IOC container.
	@Bean(name="restTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	
}
