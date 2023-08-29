package com.fssa.rishi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {


   

    // Call the database connection
    public static Connection getConnection() {

        // Database URL and credentials
        final String dbUrl;
        final String dbUser;  
        final String dbPassword;
 
//            dbUrl = System.getenv("DB_URL");
//            dbUser = System.getenv("DB_USER");
//            dbPassword = System.getenv("DB_PASSWORD");
//       
        
        dbUrl = "jdbc:mysql://localhost:3306/rishi_agri_market";
      dbUser = "root";
      dbPassword = "123456";
        
       // return DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi_agri_market", "root", "123456");
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to cnnect Database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e);

		}

    }

}
