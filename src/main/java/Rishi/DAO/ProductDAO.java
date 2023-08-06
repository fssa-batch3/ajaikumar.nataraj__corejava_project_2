package Rishi.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Rishi.DAO.exceptions.DAOException;
import Rishi.model.ProductDetails;

public class ProductDAO {

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi_agri_market", "root", "123456");
		return connection;
	}

	public boolean createProduct(ProductDetails product) throws DAOException {

		try {
			Connection connection = getConnection();

			String insertQuery = "Insert INTO productdetails (id, name, price, quantity, description, url, district, type, city, userId, pincode, uploadDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, product.getId());
			statement.setString(2, product.getName());
			statement.setInt(3, product.getPrice());
			statement.setInt(4, product.getQuantity());
			statement.setString(5, product.getDescription());
			statement.setString(6, product.getUrl());
			statement.setString(7, product.getDistrict());
			statement.setString(8, product.getType());
			statement.setString(9, product.getCity());
			statement.setInt(10, product.getUserId());
			statement.setInt(11, product.getPincode());
			statement.setDate(12, product.getUploadDate());
			
			int rows = statement.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public ProductDetails readProduct(int productId) throws DAOException {
	    try {
	        Connection connection = getConnection();
	        String selectQuery = "SELECT id, name, price, quantity, description, url, district, type, city, userId, pincode, uploadDate FROM productdetails WHERE id=?";
	        PreparedStatement statement = connection.prepareStatement(selectQuery);
	        statement.setInt(1, productId);

	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String name = resultSet.getString("name");
	            int price = resultSet.getInt("price");
	            int quantity = resultSet.getInt("quantity");
	            String description = resultSet.getString("description");
	            String url = resultSet.getString("url");
	            String district = resultSet.getString("district");
	            String type = resultSet.getString("type");
	            String city = resultSet.getString("city");
	            int userId = resultSet.getInt("userId");
	            int pincode = resultSet.getInt("pincode");
	            Date uploadDate = resultSet.getDate("uploadDate");

	            return new ProductDetails(id, name, price, quantity, description, url, district, type, city, userId, pincode, uploadDate);
	        } else {
	            return null;
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


	
	public boolean updateProduct(ProductDetails product) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String updateQuery = "UPDATE productdetails SET  name = ?, price = ?, quantity = ?, description = ?, url = ?, district = ?, type = ?, city = ?, userId = ?, pincode = ?, uploadDate = ?  WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			
			statement.setString(1, product.getName());
			statement.setInt(2, product.getPrice());
			statement.setInt(3, product.getQuantity());
			statement.setString(4, product.getDescription());
			statement.setString(5, product.getUrl());
			statement.setString(6, product.getDistrict());
			statement.setString(7, product.getType());
			statement.setString(8, product.getCity());
			statement.setInt(9, product.getUserId());
			statement.setInt(10, product.getPincode());
			statement.setDate(11, product.getUploadDate());
			statement.setInt(12, product.getId());
			
			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public boolean deleteProduct(ProductDetails product) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String deleteQuery = "DELETE FROM productdetails WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, product.getId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}

