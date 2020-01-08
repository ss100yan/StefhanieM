package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.SuperPet;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

/*
 * This is our data access object (DAO). It is an object which serves the
 * purpose of interacting with our database.
 */
public class SuperPetRepositoryImpl implements SuperPetRepository {
	
	/*
	 * Log4J is a logging tool which allows us to log to our console, a file,
	 * etc. This is preferred to using sysout as we there is a business-oriented
	 * advantage to producing logs. So let's create a logger:
	 */
	
	private static final Logger loggy = LogManager.getLogger(SuperPetRepositoryImpl.class);

	@Override
	public List<SuperPet> getAllSuperPets() {
		
		loggy.debug("The getAllSuperPets method in the repository layer has been called.");
		
		/*
		 * This method will return all of the super pets that are currently in my
		 * database. To start, we'll need a connection (and, of course, an
		 * implementation of the List interface that will hold all of the records we get
		 * back from our DB).
		 */

		List<SuperPet> superPets = null;

		Connection conn = null;
		/*
		 * I will need a statement if I want to execute a SQL statement.
		 */
		Statement stmt = null;
		/*
		 * I need a result set to hold the records that will be returned.
		 */
		ResultSet set = null;

		final String SQL = "select * from super_pet";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			superPets = new ArrayList<SuperPet>();

			while (set.next()) {
				superPets.add(
						/*
						 * The indices start at 1 (not 0) when accessing the columns on a table in a
						 * database.
						 */
						new SuperPet(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5),
								set.getString(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return superPets;
	}

	@Override
	public SuperPet getSuperPetById(int id) {
		SuperPet myPet = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		/*
		 * This time around, we are taking user input and using it to construct
		 * a query. As a result, we will be vulnerable to SQL injection if
		 * we don't use a PreparedStatement. In order to use a PreparedStatement,
		 * we can parameterize our query by using the "?" as a placeholder and then
		 * set a value for this question mark later.
		 */
		final String SQL = "select * from super_pet where super_pet_id = ?";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			/*
			 * Note that the parameter indices start from 1. A parameter
			 * index refers to a question mark you have used to parameterize
			 * a query.
			 */
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				myPet = new SuperPet(
						set.getInt(1), 
						set.getString(2), 
						set.getString(3), 
						set.getString(4), 
						set.getInt(5),
						set.getString(6)
						);
			}
			
			/*
			 * Now we have to set the parameters.
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return myPet;
	}

	@Override
	public void insertSuperPet(SuperPet superPet) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String SQL = "insert into super_pet values(?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, superPet.getId());
			stmt.setString(2, superPet.getName());
			stmt.setString(3, superPet.getPower());
			stmt.setString(4, superPet.getColor());
			stmt.setInt(5, superPet.getAge());
			stmt.setString(6, superPet.getOwner());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public void updateSuperPetById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSuperPetById(int id) {
		// TODO Auto-generated method stub
		
	}

}
