package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.utils.ConnectionUtil;

public class ProductDAO {

	

	public boolean createProduct(ProductDetails product) throws DAOException {

		try {
			Connection connection = ConnectionUtil.getConnection();

			String insertQuery = "Insert INTO product_details (id, name, price, quantity, description, url, district, type, city, seller_id, pincode, upload_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setLong(1, product.getId());
			statement.setString(2, product.getName());
			statement.setInt(3, product.getPrice());
			statement.setInt(4, product.getQuantity());
			statement.setString(5, product.getDescription());
			statement.setString(6, product.getUrl());
			statement.setString(7, product.getDistrict());
			statement.setString(8, product.getType());
			statement.setString(9, product.getCity());
			statement.setLong(10, product.getUserId());
			statement.setInt(11, product.getPincode());
			statement.setDate(12, product.getUploadDate());
			
			int rows = statement.executeUpdate();

			statement.close();
			connection.close();
			
			return (rows == 1);
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
	public static boolean readProduct() throws DAOException {
		try {
			Connection connection = ConnectionUtil.getConnection();

			String selectQuery = "SELECT * FROM product_details";
			PreparedStatement statement = connection.prepareStatement(selectQuery);

			ResultSet resultSet = statement.executeQuery();
 
			boolean userExists = resultSet.next();
			
			while (userExists) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				int quantity = resultSet.getInt("quantity");
				String description = resultSet.getString("description");
				String url = resultSet.getString("url");
				String district = resultSet.getString("district");
				String type = resultSet.getString("type");
				String city = resultSet.getString("city");
				long userId = resultSet.getLong("seller_id");
				int pincode = resultSet.getInt("pincode");
				Date uploadDate = resultSet.getDate("upload_date");

				System.out.println("Product ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Price: " + price);
				System.out.println("Quantity: " + quantity);
				System.out.println("Description: " + description);
				System.out.println("URL: " + url);
				System.out.println("District: " + district);
				System.out.println("Type: " + type);
				System.out.println("City: " + city);
				System.out.println("User ID: " + userId);
				System.out.println("Pincode: " + pincode);
				System.out.println("Upload Date: " + uploadDate);
				System.out.println("------------------------------------");
				System.out.println("------------------------------------");
				System.out.println("------------------------------------");
			}

			resultSet.close();
			statement.close();
			connection.close();
			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	
	public boolean updateProduct(ProductDetails product) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String updateQuery = "UPDATE product_details SET  name = ?, price = ?, quantity = ?, description = ?, url = ?, district = ?, type = ?, city = ?, seller_id = ?, pincode = ?, upload_date = ?  WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			
			statement.setString(1, product.getName());
			statement.setInt(2, product.getPrice());
			statement.setInt(3, product.getQuantity());
			statement.setString(4, product.getDescription());
			statement.setString(5, product.getUrl());
			statement.setString(6, product.getDistrict());
			statement.setString(7, product.getType());
			statement.setString(8, product.getCity());
			statement.setLong(9, product.getUserId());
			statement.setInt(10, product.getPincode());
			statement.setDate(11, product.getUploadDate());
			statement.setLong(12, product.getId());
			
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
	
	public boolean deleteProduct(ProductDetails product) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();
 
			// Prepare SQL statement
			String deleteQuery = "DELETE FROM product_details WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setLong(1, product.getId());

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

