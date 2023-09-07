package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.User;
import com.fssa.rishi.utils.ConnectionUtil;

public class UserDAO {

	// Get user from DB - Login
	public boolean checkUserLogin(String email, String password) throws DAOException {
	    String selectQuery = "SELECT * FROM user WHERE email = ?";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(selectQuery)) {

	        statement.setString(1, email);

	        try (ResultSet resultSet = statement.executeQuery()) {
	            boolean userExists = resultSet.next(); 

	            if (userExists) {
	                String storedPassword = resultSet.getString("password");
	                if (storedPassword.equals(password)) {
	                    return true;
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


	public boolean createUser(User user) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement("INSERT INTO user (id, email, username, password, phone_number, pincode, address) VALUES(?, ?, ?, ?, ?, ?, ?)")) {

	        statement.setLong(1, user.getId());
	        statement.setString(2, user.getEmail());
	        statement.setString(3, user.getUsername());
	        statement.setString(4, user.getPassword());
	        statement.setLong(5, user.getPhoneNumber());
	        statement.setInt(6, user.getPincode());
	        statement.setString(7, user.getAddress());

	        int rows = statement.executeUpdate();

	        return (rows == 1);

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


	public List<User> readUser() throws DAOException {

		List<User> userList = new ArrayList<>();
		String selectQuery = "SELECT * FROM user";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					User userResult = new User();
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

					userList.add(userResult);
				}
				return userList;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public boolean updateUser(User user) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement("UPDATE user SET username = ?, password = ?, phone_number = ?, district = ?, state = ?, address = ?, dob = ?, pincode = ?, gender = ?, id = ? WHERE email = ?")) {

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

	        int rows = statement.executeUpdate();

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

	public boolean deleteUser(User user) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement("UPDATE user SET is_deleted = ? WHERE email = ?")) {

	        statement.setInt(1, user.getIsDeleted() ? 1 : 0);
	        statement.setString(2, user.getEmail());

	        int rows = statement.executeUpdate();

	        return (rows == 1); 

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


}
