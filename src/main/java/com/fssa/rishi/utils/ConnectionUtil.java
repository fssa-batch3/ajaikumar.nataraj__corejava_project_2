package com.fssa.rishi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {


   

    // Call the database connection
    public static Connection getConnection() {
    	// Cloud DB
    			final String DB_URL = System.getenv("DB_URL_1");
    			final String DB_USER = System.getenv("DB_USER_1");
    			final String DB_PASSWORD = System.getenv("DB_PASSWORD_1");
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to cnnect Database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e);

		}

    }

}
