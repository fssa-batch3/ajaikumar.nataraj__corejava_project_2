package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.model.User;
import com.fssa.rishi.utils.ConnectionUtil;

public class ProductDAO {
	public boolean createProduct(ProductDetails product) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO product_details (id, name, price, quantity, description, url, address, type, district, seller_id, pincode, upload_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			statement.setLong(1, product.getId());
			statement.setString(2, product.getName());
			statement.setInt(3, product.getPrice());
			statement.setInt(4, product.getQuantity());
			statement.setString(5, product.getDescription());
			statement.setString(6, product.getUrl());
			statement.setString(7, product.getAddress());
			statement.setString(8, product.getType());
			statement.setString(9, product.getDistrict());
			statement.setLong(10, product.getUserId());
			statement.setInt(11, product.getPincode());
			statement.setDate(12, Date.valueOf(product.getUploadDate()));

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<ProductDetails> readProduct() throws DAOException {

		List<ProductDetails> productList = new ArrayList<>();
		String selectQuery = "SELECT * FROM product_details";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					if (resultSet.getInt("is_deleted") == 0) {
						ProductDetails productResult = new ProductDetails();
						productResult.setId(resultSet.getLong("id"));
						productResult.setName(resultSet.getString("name"));
						productResult.setPrice(resultSet.getInt("price"));
						productResult.setQuantity(resultSet.getInt("quantity"));
						productResult.setDescription(resultSet.getString("description"));
						productResult.setUrl(resultSet.getString("url"));
						productResult.setAddress(resultSet.getString("address"));
						productResult.setType(resultSet.getString("type"));
						productResult.setDistrict(resultSet.getString("district"));
						productResult.setUserId(resultSet.getLong("seller_id"));
						productResult.setPincode(resultSet.getInt("pincode"));
						productResult.setUploadDate(resultSet.getDate("upload_date").toLocalDate());

						productList.add(productResult);
					}
				}
				return productList;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}
	
	public List<ProductDetails> readOwnProduct(long id) throws DAOException {

		List<ProductDetails> productList = new ArrayList<>();
		String selectQuery = "SELECT * FROM product_details WHERE seller_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					if (resultSet.getInt("is_deleted") == 0) {
						ProductDetails productResult = new ProductDetails();
						productResult.setId(resultSet.getLong("id"));
						productResult.setName(resultSet.getString("name"));
						productResult.setPrice(resultSet.getInt("price"));
						productResult.setQuantity(resultSet.getInt("quantity"));
						productResult.setDescription(resultSet.getString("description"));
						productResult.setUrl(resultSet.getString("url"));
						productResult.setAddress(resultSet.getString("address"));
						productResult.setType(resultSet.getString("type"));
						productResult.setDistrict(resultSet.getString("district"));
						productResult.setUserId(resultSet.getLong("seller_id"));
						productResult.setPincode(resultSet.getInt("pincode"));
						productResult.setUploadDate(resultSet.getDate("upload_date").toLocalDate());

						productList.add(productResult);
					}
				}
				return productList;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public boolean updateProduct(ProductDetails product) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE product_details SET name = ?, price = ?, quantity = ?, description = ?, url = ?, address = ?, type = ?, district = ?, pincode = ? WHERE id = ?")) {

			statement.setString(1, product.getName());
			statement.setInt(2, product.getPrice());
			statement.setInt(3, product.getQuantity());
			statement.setString(4, product.getDescription());
			statement.setString(5, product.getUrl());
			statement.setString(6, product.getAddress());
			statement.setString(7, product.getType());
			statement.setString(8, product.getDistrict());
			statement.setInt(9, product.getPincode());
			statement.setLong(10, product.getId());

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public static ProductDetails findProductById(long id) throws DAOException {
		final String SELECTQUERY = "SELECT * FROM product_details WHERE id = ?";

		ProductDetails product = new ProductDetails();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(SELECTQUERY)) {

			pmt.setLong(1, id);

			try (ResultSet rs = pmt.executeQuery()) {
				if (rs.next()) {
					product.setId(rs.getLong("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getInt("price"));
					product.setUrl(rs.getString("url"));
					product.setQuantity(rs.getInt("quantity"));
					product.setDescription(rs.getString("description"));
					product.setType(rs.getString("type"));
					product.setDistrict(rs.getString("district"));
					product.setAddress(rs.getString("address"));
					product.setPincode(rs.getInt("pincode"));

				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return product;
	}

	public boolean deleteProduct(ProductDetails product) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE product_details SET is_deleted = ? WHERE id = ?")) {

			statement.setInt(1, product.getIsDeleted() ? 0 : 1);
			statement.setLong(2, product.getId());

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
