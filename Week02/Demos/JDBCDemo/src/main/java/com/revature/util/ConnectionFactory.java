package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This is a factory which we will use to create connections. Note that it
 * is just a convenience class.
 */
public class ConnectionFactory {

	private static Connection connection; //JDBC Connection
	
	public static Connection getConnection() {
		try {
			/*
			 * Sometimes, your driver class cannot be found. In order to fix
			 * this problem, you must explicitly specify what the driver class
			 * is like so:
			 */
			Class.forName("org.postgresql.Driver");
			/*
			 * NOTE: Hardcoding your credentials into the application is BAD
			 * as you might expose your credentials the world when pushing
			 * your application up to a repository. You should instead use
			 * environment variables or a properties file and pull your
			 * credentials from one of those sources.
			 */
			connection = DriverManager.getConnection(
					/*
					 * We're using environment variables.
					 */
					System.getenv("dburl"),
					System.getenv("dbusername"),
					System.getenv("dbpassword")
					);
		} catch (SQLException | ClassNotFoundException e) {
			//SQLException is a checked exception, which means it must be
			//handled.
			e.printStackTrace();
		}
		
		return connection;
	}
}
