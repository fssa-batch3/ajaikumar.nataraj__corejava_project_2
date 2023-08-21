package com.fssa.rishi.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.rishi.DAO.exceptions.DAOException;
import com.fssa.rishi.model.User;
import com.fssa.rishi.utils.ConnectionUtil;

public class UserDAO { 


	// Get user from DB - Login
	public boolean checkUserLogin(String email, String password) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			String selectQuery = "SELECT * FROM user WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, email);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();

			boolean userExists = resultSet.next();

			if (userExists) {
				System.out.println("User present.");
				String storedPassword = resultSet.getString("password");
				System.out.println(storedPassword);
				if (storedPassword.equals(password)) {
					System.out.println("User successfully logged in.");
				} else {
					System.out.println("Incorrect password.");
				}
			} else {
				System.out.println("User credentials not exists.");
			}
			
			resultSet.close();
			statement.close();
			connection.close();

			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean createSeller(User seller) throws DAOException {

		try {
			// Get connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi_agri_market", "root", "123456");
			
			// Prepare SQL statement
			String insertQuery = "Insert INTO user (email, username, password, phoneNumber, pincode, address, isSeller, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, seller.getEmail());
			statement.setString(2, seller.getUsername());
			statement.setString(3, seller.getPassword());
			statement.setLong(4, seller.getPhoneNumber());
			statement.setInt(5, seller.getPincode());
			statement.setString(6, seller.getAddress());
			statement.setInt(7, seller.getIsSeller() ? 1 : 0);
			statement.setLong(8, seller.getId());
			
			// Execute the query
			int rows = statement.executeUpdate();

			statement.close();
			connection.close();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public boolean createUser(User user) throws DAOException {

		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO user (id, email, username, password, phoneNumber, pincode, address) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setLong(1, user.getId());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			statement.setLong(5, user.getPhoneNumber());
			statement.setInt(6, user.getPincode());
			statement.setString(7, user.getAddress());

			// Execute the query
			int rows = statement.executeUpdate();

			statement.close();
			connection.close();
			
			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public boolean updateUser(User user) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String updateQuery = "UPDATE user SET  username = ?, password = ?, phoneNumber = ?, district = ?, state = ?, address = ?, dob = ?, pincode = ?, gender = ?, id = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setLong(3, user.getPhoneNumber());
			statement.setString(4, user.getDistrict());
			statement.setString(5, user.getState());
			statement.setString(6, user.getAddress());
			statement.setDate(7, user.getDob());
			statement.setInt(8, user.getPincode());
			statement.setString(9, user.getGender());
			statement.setLong(10, user.getId());
			statement.setString(11, user.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			statement.close();
			connection.close();
			
			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public boolean deleteUser(User user) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String deleteQuery = "UPDATE user SET  isDeleted = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			
			statement.setInt(1, user.getIsDeleted() ? 1 : 0);
			statement.setString(2, user.getEmail());
			

			// Execute the query
			int rows = statement.executeUpdate();

			statement.close();
			connection.close();
			 
			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}

