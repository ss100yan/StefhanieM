package com.revature.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
	
}
