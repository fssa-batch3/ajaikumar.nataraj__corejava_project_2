package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	


	public List<ProductDetails> listProduct() throws DAOException {
	    List<ProductDetails> products = new ArrayList<>();
	    try {
	        Connection connection = ConnectionUtil.getConnection();

			String selectQuery = "SELECT * FROM product_details";
	        PreparedStatement statement = connection.prepareStatement(selectQuery);

	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
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
					java.sql.Date uploadDate = resultSet.getDate("upload_date");

	                // Create and add Seller object to the list
					ProductDetails product = new ProductDetails();
					product.setId(id);
					product.setName(name);
					product.setPrice(price);
					product.setQuantity(quantity);
					product.setDescription(description);
					product.setUrl(url);
					product.setDistrict(district);
					product.setType(type);
					product.setCity(city);
					product.setUserId(userId);
					product.setPincode(pincode);
					product.setUploadDate(uploadDate);
					
					
					
					products.add(product);
	            
	        }

	        resultSet.close();

	    } catch (SQLException e) {
	        // Handle the exception appropriately
	        throw new DAOException (e);
	    }

	    return products;
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

