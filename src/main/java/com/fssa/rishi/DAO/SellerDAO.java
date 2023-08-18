package com.fssa.rishi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.rishi.DAO.exceptions.DAOException;
import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;

public class SellerDAO {

	// Connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi_agri_market", "root",
				"123456");
		return connection;
	}

	// Get user from DB - Login
	public boolean checkSellerLogin(String email, String password) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

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

	public boolean createSeller(Seller seller) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();
			
			// Prepare SQL statement
			String insertQuery = "Insert INTO user (email, username, password, phoneNumber, pincode, address, isSeller, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, seller.getEmail());
			statement.setString(2, seller.getUsername());
			statement.setString(3, seller.getPassword());
			statement.setString(4, seller.getPhoneNumber());
			statement.setInt(5, seller.getPincode());
			statement.setString(6, seller.getHomeAddress());
			statement.setInt(7, seller.getIsSeller() ? 1 : 0);
			statement.setString(8, seller.getId());
			
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
	
	public boolean createUser(Seller seller) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO seller (id, landAddress, landType, email) VALUES(?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, seller.getId());
			statement.setString(2, seller.getLandAddress());
			statement.setString(3, seller.getLandType());
			statement.setString(4, seller.getEmail());

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

	public boolean updateUser(User seller) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String updateUserQuery = "UPDATE user SET id = ?, username = ?, password = ?, phoneNumber = ?, district = ?, state = ?, address = ?, landAddress = ?, dob = ?, pincode = ?, gender = ?, LandType = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(updateUserQuery);
			statement.setString(1, seller.getId());
			statement.setString(2, seller.getUsername());
			statement.setString(3, seller.getPassword());
			statement.setString(4, seller.getPhoneNumber());
			statement.setString(5, seller.getDistrict());
			statement.setString(6, seller.getState());
			statement.setString(7, seller.getAddress());
			statement.setDate(9, seller.getDob());
			statement.setInt(10, seller.getPincode());
			statement.setString(11, seller.getGender());
			statement.setBoolean(13, seller.getIsSeller());
			statement.setString(14, seller.getEmail());

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
	
	public boolean updateUser(Seller seller) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();
			
			// Prepare SQL statement
			String updateSellerQuery = "UPDATE seller SET id = ?, landAddress = ?, LandType = ? WHERE email = ?";
			PreparedStatement statementSeller = connection.prepareStatement(updateSellerQuery);
			statementSeller.setString(1, seller.getId());
			statementSeller.setString(2, seller.getLandAddress());
			statementSeller.setString(3, seller.getLandType());
			statementSeller.setString(4, seller.getEmail());

			int sellerRows = statementSeller.executeUpdate();
			
			statementSeller.close();
			connection.close();

			// Return successful or not
			return (sellerRows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean deleteUser(User user) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

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
