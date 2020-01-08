package com.revature.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.SuperOwner;
import com.revature.util.MySessionFactory;

public class SuperOwnerRepositoryImpl implements SuperOwnerRepository{

	@Override
	public void insertSuperOwner(SuperOwner so) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = MySessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(so);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}
