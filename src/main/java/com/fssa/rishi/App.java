package com.fssa.rishi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.rishi.model.User;

public class App {
	// Connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi_agri_market", "root", "123456");
		return connection;
	}

	// Get user from DB - Login
	public boolean login(String email, String password) {
		return false;
	}

	public boolean register(User user) throws SQLException {
		// Get connection
		Connection connection = getConnection();
 
		// Prepare SQL statement
		String insertQuery = "Insert INTO user (email, username, password) VALUES(?, ?,?)";
		PreparedStatement statement = connection.prepareStatement(insertQuery);
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getUsername());
		statement.setString(3, user.getPassword());

		// Execute the query
		int rows = statement.executeUpdate();

		// Return successful or not
		return (rows == 1);
	}

	// Get user from DB - Log in

}
