package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * This is just a utility class that will allow us to handle the SQLException
 * that is thrown each time we attempt to close a connection, result set, or
 * statement in one place.
 */
public class ConnectionClosers {

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet set) {
		try {
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
