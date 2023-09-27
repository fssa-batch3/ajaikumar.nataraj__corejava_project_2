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
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement("INSERT INTO user (email, username, password, phone_number, pincode, address, is_seller, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)")) {

	        statement.setString(1, seller.getEmail());
	        statement.setString(2, seller.getUsername());
	        statement.setString(3, seller.getPassword());
	        statement.setLong(4, seller.getPhoneNumber());
	        statement.setInt(5, seller.getPincode());
	        statement.setString(6, seller.getHomeAddress());
	        statement.setInt(7, seller.getIsSeller() ? 1 : 0);
	        statement.setLong(8, seller.getId());

	        int rows = statement.executeUpdate();

	        return (rows == 1); 

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


	// Get user from DB - Login
	// Get user from DB - Login
		public boolean checkUserLogin(String email, String password) throws DAOException {
			String selectQuery = "SELECT password, is_deleted, is_seller, email FROM user WHERE email = ?";

			try (Connection connection = ConnectionUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(selectQuery)) {

				statement.setString(1, email);

				try (ResultSet resultSet = statement.executeQuery()) {
					boolean userExists = resultSet.next();

					if (userExists) {
						String storedPassword = resultSet.getString("password");
						if (storedPassword.equals(password)) {
							if (resultSet.getInt("is_deleted") == 0) {
								return true;
							} else {
								throw new DAOException("Your Account is already deleted");
							}
						} else {
							throw new DAOException("Incorrect password.");
						}
					} else {
						throw new DAOException("User credentials not exist.");
					}
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	
//	// Check the user is already exists or not
//		public boolean checkUserDataExistOrNot(String email) throws DAOException {
//			String selectQuery = "SELECT email FROM user WHERE email = ?";
//			try (Connection connection = ConnectionUtil.getConnection();
//
//					PreparedStatement statement = connection.prepareStatement(selectQuery)) {
//				statement.setString(1, email);
//
//				try (ResultSet resultSet = statement.executeQuery()) {
//					if (resultSet.next()) {
//						throw new DAOException("User email already exist, try another email");
//					} else {
//						return true;
//					}
//				}
//
//			} catch (SQLException e) {
//				throw new DAOException(e);
//			}
//		}

		

}
