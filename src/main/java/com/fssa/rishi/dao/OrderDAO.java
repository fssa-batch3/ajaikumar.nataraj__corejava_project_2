package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Order;
import com.fssa.rishi.utils.ConnectionUtil;

public class OrderDAO {

	public boolean createOrder(Order order) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO ordered_details (id, user_id, seller_id, product_id, url, name, price, quantity, phone_number, user_address, district, pincode, ordered_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			// System.out.println("orderdao" + order.toString());
			statement.setLong(1, order.getId());
			statement.setLong(2, order.getuser_id());
			statement.setLong(3, order.getSeller_id());
			statement.setLong(4, order.getproductId());
			statement.setString(5, order.getUrl());
			statement.setString(6, order.getName());
			statement.setInt(7, order.getPrice());
			statement.setInt(8, order.getQuantity());
			statement.setLong(9, order.getPhone_number());
			statement.setString(10, order.getUser_address());
			statement.setString(11, order.getDistrict());
			statement.setInt(12, order.getPincode());
			statement.setDate(13, Date.valueOf(order.getordered_date()));

//			System.out.println("order dao" + order.getUrl());

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean createOrders(List<Order> orders) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO ordered_details (id, user_id, seller_id, product_id, url, name, price, quantity, phone_number, user_address, district, pincode, ordered_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			for (Order order : orders) {
				System.out.println("orderdao" + order.toString());

				statement.setLong(1, order.getId());
				statement.setLong(2, order.getuser_id());
				statement.setLong(3, order.getSeller_id());
				statement.setLong(4, order.getproductId());
				statement.setString(5, order.getUrl());
				statement.setString(6, order.getName());
				statement.setInt(7, order.getPrice());
				statement.setInt(8, order.getQuantity());
				statement.setLong(9, order.getPhone_number());
				statement.setString(10, order.getUser_address());
				statement.setString(11, order.getDistrict());
				statement.setInt(12, order.getPincode());
				statement.setDate(13, Date.valueOf(order.getordered_date()));

				statement.addBatch();
			}

			int[] rows = statement.executeBatch();

			// Check if all rows were inserted successfully
			for (int row : rows) {
				if (row != 1 && row != Statement.SUCCESS_NO_INFO) {
					return false; // Insertion failed
				}
			}

			return true; // All orders were inserted successfully
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Retrieve a Order by its ID
	public List<Order> getOrdersByUserId(long userId) throws DAOException {
		String selectQuery = "SELECT * FROM ordered_details WHERE user_id = ?";
		List<Order> orders = new ArrayList<>();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
			selectStatement.setLong(1, userId);
			ResultSet resultSet = selectStatement.executeQuery();

			while (resultSet.next()) {
				Order order = new Order(resultSet.getLong("id"), resultSet.getLong("user_id"),
						resultSet.getLong("seller_id"), resultSet.getLong("product_id"), resultSet.getString("url"),
						resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("quantity"),
						resultSet.getLong("phone_number"), resultSet.getString("user_address"),
						resultSet.getString("district"), resultSet.getInt("pincode"),
						resultSet.getDate("ordered_date").toLocalDate(), resultSet.getInt("status"));

				orders.add(order);
			}
		} catch (SQLException e) {
			throw new DAOException("Error retrieving orders by user ID");
		}

		return orders;
	}

	public List<Order> getOrdersByUserIdForNotification(long userId) throws DAOException {
		// String selectQuery = "SELECT od.*, pd.url FROM ordered_details AS od INNER
		// JOIN product_details AS pd ON od.product_id = pd.id INNER JOIN user AS u ON
		// pd.seller_id = u.id WHERE u.id = ? AND od.status = 0;";
		// String selectQuery = "SELECT * FROM ordered_details WHERE seller_id = ?";
		String selectQuery = "SELECT od.*, u.* FROM ordered_details AS od INNER JOIN user AS u ON od.user_id = u.id where od.seller_id = ?";

		List<Order> orders = new ArrayList<>();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
			selectStatement.setLong(1, userId);
			ResultSet resultSet = selectStatement.executeQuery();

			while (resultSet.next()) {
				Order order = new Order(resultSet.getLong("id"), resultSet.getLong("user_id"),
						resultSet.getLong("seller_id"), resultSet.getLong("product_id"), resultSet.getString("url"),
						resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("quantity"),
						resultSet.getLong("phone_number"), resultSet.getString("user_address"),
						resultSet.getString("district"), resultSet.getInt("pincode"),
						resultSet.getDate("ordered_date").toLocalDate(), resultSet.getInt("status"),
						resultSet.getString("username"));
				System.out.println(resultSet.getString("username"));

				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error retrieving orders by user ID");
		}

		return orders;
	}

	// Update an existing Order
	public boolean updateOrder(Order Order) throws DAOException {
		String updateQuery = "UPDATE ordered_details SET name = ?, price = ?, quantity = ?, user_address = ?, district = ?, pincode = ?,  ordered_date = ? WHERE id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
			updateStatement.setString(1, Order.getName());
			updateStatement.setInt(2, Order.getPrice());
			updateStatement.setInt(3, Order.getQuantity());
			updateStatement.setDate(5, java.sql.Date.valueOf(Order.getordered_date()));
			updateStatement.setString(6, Order.getUser_address());
			updateStatement.setLong(7, Order.getproductId());

			int rowsUpdated = updateStatement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			throw new DAOException("Error updating Order");
		}
	}

	// Update an existing Order
	public boolean updateUserDetailInOrder(Order order) throws DAOException {
		System.out.println(order);
		String updateQuery = "UPDATE ordered_details SET phone_number = ?, user_address = ?, district = ?, pincode = ? WHERE user_id = ? AND ordered_date = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
			updateStatement.setLong(1, order.getPhone_number());
			updateStatement.setString(2, order.getUser_address());
			updateStatement.setString(3, order.getDistrict());
			updateStatement.setInt(4, order.getPincode());
			updateStatement.setLong(5, order.getuser_id());
			updateStatement.setDate(6, Date.valueOf(order.getordered_date()));

			int rowsUpdated = updateStatement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			throw new DAOException("Error updating order");
		}
	}

	public boolean NotificationAccept(long id) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE ordered_details SET status = 1 WHERE id = ?")) {

			statement.setLong(1, id);

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean NotificationReject(long id) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE ordered_details SET status = -1 WHERE id = ?")) {

			statement.setLong(1, id);

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Delete a Order by its ID
	public boolean deleteOrder(long OrderId) throws DAOException {
		String deleteQuery = "DELETE FROM ordered_details WHERE id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
			deleteStatement.setLong(1, OrderId);
			int rowsDeleted = deleteStatement.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			throw new DAOException("Error deleting Order by ID");
		}
	}
}
