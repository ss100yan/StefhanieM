package com.revature;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.SuperOwner;
import com.revature.model.SuperPet;
import com.revature.service.SuperOwnerService;
import com.revature.service.SuperPetService;

public class Driver {

	public static void main(String[] args) {
		SuperPetService sps = new SuperPetService();
		SuperOwnerService sos = new SuperOwnerService();
		
		/*
		 * Let's attempt to create a SuperPet to insert into our database.
		 */
		
//		SuperPet sp = new SuperPet(1, "Another Name", "Another Color", "Another Power", 1001);
		
//		sps.insertSuperPet(sp);
//		System.out.println(sps.getAllSuperPets());
//		System.out.println(sps.getSuperPetByName("EHCACHE"));
		
		SuperOwner superOwner = new SuperOwner(1, "Curtis", "I don't know. Which Curtis is it?");
		SuperPet superPetWithOwner = new SuperPet(1, "Curtis's Pet", "Some Color", "Belonging to Some Curtis", 1, superOwner);
		
		sos.insertSuperOwner(superOwner);
		sps.insertSuperPet(superPetWithOwner);
		//The SuperOwner is eagerly fetched in this example.
		System.out.println(sps.getAllSuperPets());
		
		
		/*
		 * Hibernate provides several ways of retrieving, persisting, and
		 * updating records. That said, there are slight differences between
		 * how the various methods work.
		 * 
		 * GET vs LOAD:
		 * 
		 * Both GET and LOAD will fetch a record from the database, but
		 * GET returns null if no such record is found while LOAD throws
		 * an ObjectNotFoundException if no such record is found.
		 */
		
		Session session = null;
		Transaction tx = null;
		SuperPet retrievedSp = null;
		
//		try {
//			session = MySessionFactory.getSession();
//			tx = session.beginTransaction();
////			retrievedSp = session.get(SuperPet.class, 100); //GET
//			retrievedSp = session.load(SuperPet.class, 100); //LOAD
//			System.out.println(retrievedSp);
//			tx.commit();
//		}catch(HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
		
		/*
		 * Both SAVE and PERSIST can be used to persist a record to your DB,
		 * but SAVE immediately returns the identifier for the record while
		 * persist only promises to persist the record sometime before
		 * the session is closed.
		 */
		
//		SuperPet savedSp = new SuperPet(1, "Blues Clues", "Blue", "Being Really Cute", 10);
		
//		try {
//			session = MySessionFactory.getSession();
//			tx = session.beginTransaction();
////			System.out.println(session.save(savedSp)); //SAVE
//			session.persist(savedSp); //PERSIST
//			System.out.println(savedSp);
//			tx.commit();
//		}catch(HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
		
		/*
		 * Both MERGE and UPDATE allow you to update a record in your DB, but
		 * merge works with transient and detached instances whereas update
		 * does not work with transient instances.
		 */
		
//		SuperPet updatedSp = new SuperPet(100, "Merge Is Terrible", "Grey", "Getting Stomped Out", -1);
		
//		try {
//			session = MySessionFactory.getSession();
//			tx = session.beginTransaction();
////			session.update(updatedSp); //UPDATE
//			System.out.println(session.merge(updatedSp)); //MERGE
//			System.out.println(session.get(SuperPet.class, 1));
//			tx.commit();
//		}catch(HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
	}
}
