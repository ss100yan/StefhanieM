package com.revature.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.revature.model.SuperPet;
import com.revature.util.MySessionFactory;

/*
 * In order to create Spring beans using annotations, we must use what we refer to
 * Spring Stereotypes. These stereotypes are annotations which tell the framework
 * that we want it to manage the life cycle of any instance of this class.
 * 
 * There are specialized stereotypes which have conventional uses:
 * 
 * @Component (a very general stereotype which should only be used when you
 * don't know a more specific)
 * @Service (use in the service of our application; denotes that class handles business
 * logic)
 * @Repository(used in the data layer of our application)
 * @Controller/@RestController(used in the web layer of our application)
 */

//This "value" corresponds to the component name.
@Repository(value="superPetRepository")
public class SuperPetRepositoryImpl implements SuperPetRepository {

	public void insertSuperPet(SuperPet s) { //TRANSIENT
		/*
		 * We'll need a session in order to interact with our DB. We'll
		 * also need a transaction to perform work on our database.
		 */
		Session session = null;
		Transaction tx = null;
		
		try {
			session = MySessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(s); //PERSISTENT
//			session.evict(s); //DETACHED AS WELL
			tx.commit();
		}catch(HibernateException e) {
			/*
			 * If something should go wrong, let's roll back our transaction.
			 */
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();  //DETACHED
		}
		
	}
	
//	public SuperPet getSuperPetByName(String name) {
//		SuperPet sp = null;
//		Session session = null;
//		Transaction tx = null;
//		
//		/*
//		 * This time around, we're going to use the Criteria API to impose
//		 * some restrictions on our query. This is equivalent to adding
//		 * where clauses to our queries - but in an object-oriented way.
//		 */
//		try {
//			session = MySessionFactory.getSession();
//			tx = session.beginTransaction();
//			CriteriaBuilder cb = session.getCriteriaBuilder();
//			CriteriaQuery<SuperPet> cq = cb.createQuery(SuperPet.class);
//			Root<SuperPet> root = cq.from(SuperPet.class);
//			cq.select(root).where(cb.equal(root.get("name"), name));
//			Query<SuperPet> q = session.createQuery(cq);
//			sp = q.getSingleResult();
//			tx.commit();
//		}catch(HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//		return sp;
//	}
	
	/*
	 * We can also get a SuperPet by it's name by using parameterized HQL.
	 */
	
	public SuperPet getSuperPetByName(String name) {
		SuperPet sp = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			session = MySessionFactory.getSession();
			tx = session.beginTransaction();
			sp = session.createQuery("FROM SuperPet where name = :name", SuperPet.class)
					//You can actually provide the name of the parameter.
					.setParameter("name", name)
					.uniqueResult();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return sp;
	}

//	@Override
//	public List<SuperPet> getAllSuperPets() {
//		List<SuperPet> superPets = null;
//		Session session = null;
//		Transaction tx = null;
//		
//		try {
//			session = MySessionFactory.getSession();
//			tx = session.beginTransaction();
//			/*
//			 * This is how we use HQL. Remember that HQL is Hibernate's built-in
//			 * query language that allows us to take a more object-oriented
//			 * approach to querying the DB.
//			 */
//			superPets = session.createQuery("FROM SuperPet").getResultList();
//			tx.commit();
//		}catch(HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//		
//		return superPets;
//	}
	
	public List<SuperPet> getAllSuperPets(){
		List<SuperPet> superPets = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			session = MySessionFactory.getSession();
			tx = session.beginTransaction();
			/*
			 * You still have the option to use native SQL with Hibernate. We can do
			 * so by using a Native Query.
			 */
			superPets = session.createNativeQuery("select * from SuperPetTable", SuperPet.class).list();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return superPets;
	}

	
	public void deleteSuperPet(SuperPet s) {
		// TODO Auto-generated method stub
		
	}

	public void updateSuperPet(SuperPet s) {
		// TODO Auto-generated method stub
		
	}

}
