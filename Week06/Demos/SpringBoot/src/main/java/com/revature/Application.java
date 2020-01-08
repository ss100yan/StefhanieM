package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This @SpringBootApplication annotation is a convenience annotation that consists of
 * several other annotations. These include:
 * 
 * @SpringBootConfiguration: This is an alternative to the @Configuration tag. It allows
 * Spring to auto detect configuration.
 * 
 * @EnableAutoConfiguration: This enables the auto configuration of the application
 * context.
 * 
 * @ComponentScan: This indicates that Spring should scan this package for annotations.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
