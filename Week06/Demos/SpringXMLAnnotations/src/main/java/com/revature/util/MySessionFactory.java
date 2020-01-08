package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * This is where we will build our SessionFactory using our Configuration
 * class. Note that our SessionFactory will be a singleton; we don't, after
 * all, need more than one instance of a SessionFactory.
 */
public class MySessionFactory {

	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", System.getenv("dburl"))
					.setProperty("hibernate.connection.username", System.getenv("dbusername"))
					.setProperty("hibernate.connection.password", System.getenv("dbpassword"))
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
