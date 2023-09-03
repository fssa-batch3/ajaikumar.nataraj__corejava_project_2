package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.utils.ConnectionUtil;

public class SellerDAO {

	
	public boolean createSeller(Seller seller) throws DAOException {

		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO user (email, username, password, phone_number, pincode, address, is_seller, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, seller.getEmail()); 
			statement.setString(2, seller.getUsername()); 
			statement.setString(3, seller.getPassword());
			statement.setLong(4, seller.getPhoneNumber());
			statement.setInt(5, seller.getPincode());
			statement.setString(6, seller.getHomeAddress());
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

	public boolean createUser(Seller seller) throws DAOException {

		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO seller (id, land_address, land_type, email) VALUES(?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setLong(1, seller.getId());
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
	
	// Check the user is already exists or not
		public boolean checkUserDataExistOrNot(String email) throws DAOException {
			String selectQuery = "SELECT email FROM user WHERE email = ?";
			try (Connection connection = ConnectionUtil.getConnection();

					PreparedStatement statement = connection.prepareStatement(selectQuery)) {
				statement.setString(1, email);

				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						throw new DAOException("User email already exist, try another email");
					} else {
						return true;
					}
				}

			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		 public List<User> readUser(Seller user) throws DAOException {
		        List<User> userList = new ArrayList<>();

		        String selectQuery = "SELECT * FROM user INNER JOIN seller ON user.email = seller.email WHERE user.email = ?";
		        
		        try (Connection connection = ConnectionUtil.getConnection();
		             PreparedStatement statement = connection.prepareStatement(selectQuery)) {
		            statement.setString(1, user.getEmail());

		            try (ResultSet resultSet = statement.executeQuery()) {
		                while (resultSet.next()) {
		                    User userResult = new User();
		                    Seller sellerResult = new Seller();

		                    userResult.setEmail(resultSet.getString("email"));
		                    userResult.setUsername(resultSet.getString("username"));
		                    userResult.setPassword(resultSet.getString("password"));
		                    userResult.setPhoneNo(resultSet.getLong("phone_number"));
		                    userResult.setDistrict(resultSet.getString("district"));
		                    userResult.setState(resultSet.getString("state"));
		                    userResult.setAddress(resultSet.getString("address"));
		                    userResult.setDob(resultSet.getDate("dob"));
		                    userResult.setPincode(resultSet.getInt("pincode"));
		                    userResult.setGender(resultSet.getString("gender"));

		                    sellerResult.setLandAddress(resultSet.getString("landAddress"));
		                    sellerResult.setLandType(resultSet.getString("landType"));

		                    userResult.setIsSeller(sellerResult); // Assuming User has a setter for Seller
		                    
		                    userList.add(userResult);
		                }
		                return userList;
		            }
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
		    }

	public boolean updateUser(Seller seller) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String updateSellerQuery = "UPDATE seller SET id = ?, land_address = ?, land_type = ? WHERE email = ?";
			PreparedStatement statementSeller = connection.prepareStatement(updateSellerQuery);
			statementSeller.setLong(1, seller.getId());
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

	
	
}
