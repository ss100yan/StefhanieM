package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.SuperPetService;

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * We are using an XML file that is on our classpath as our Application Context,
		 * so the implementation of our ApplicationContext is the 
		 * ClassPathXmlApplicationContext. We can use the context to grab a bean
		 * from our IOC container.
		 * 
		 * There are other implementations of the ApplicationContext. These include:
		 * 
		 * FileSystemXmlApplicationContext
		 * XmlWebApplicationContext
		 * AnnotationConfigApplicationContext
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Let's use our context to grab one of the beans we've defined there:
		
		SuperPetService sps = ac.getBean("superPetService", SuperPetService.class);
		
		System.out.println(sps.getAllSuperPets());
	}
}
