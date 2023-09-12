package com.fssa.rishi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// Call the database connection
	public static Connection getConnection() {
	    // Cloud DB
	    final String DB_URL = System.getenv("DB_URL1");
	    final String DB_USER = System.getenv("DB_USER1");
	    final String DB_PASSWORD = System.getenv("DB_PASSWORD1");

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    } catch (ClassNotFoundException e) {
	        throw new RuntimeException("Database driver class not found", e);
	    } catch (SQLException e) {
	        throw new RuntimeException("Unable to connect to the database. Check your connection settings.", e);
	    }
	}


}
