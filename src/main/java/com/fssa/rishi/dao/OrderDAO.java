package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Order;
import com.fssa.rishi.utils.ConnectionUtil;

public class OrderDAO {

	public boolean createOrder(long id) throws DAOException {
		String selectQuery = "SELECT * FROM product_details where id=?";
		String insertQuery = "INSERT INTO Ordered_details (user_id, product_id, name, price, quantity, user_address, district, pincode, ordered_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = selectStatement.executeQuery();
				PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
			while (resultSet.next()) {
				// Map the columns from the source table to the destination table columns
				insertStatement.setLong(1, resultSet.getLong("user_id"));
				insertStatement.setLong(2, resultSet.getLong("product_id"));
				insertStatement.setString(3, resultSet.getString("name"));
				insertStatement.setInt(4, resultSet.getInt("price"));
				insertStatement.setInt(5, resultSet.getInt("quantity"));
				insertStatement.setString(6, resultSet.getString("user_address"));
				insertStatement.setString(7, resultSet.getString("district"));
				insertStatement.setInt(8, resultSet.getInt("pincode"));
				insertStatement.setDate(9, resultSet.getDate("order_date"));

				// Execute the insert statement
				insertStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	 // Retrieve a Order by its ID
    public Order getOrderById(long OrderId) throws DAOException {
        String selectQuery = "SELECT * FROM Order WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setLong(1, OrderId);
            ResultSet resultSet = selectStatement.executeQuery();
            
            if (resultSet.next()) {
                // Map the result set to a Order object
                Order Order = new Order(
                    resultSet.getLong("id"),
                    resultSet.getLong("product_id"),
                    resultSet.getLong("buyer_id"),
                    resultSet.getString("name"),
                    resultSet.getInt("price"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("url"),
                    resultSet.getDate("order_date").toLocalDate(),
                    resultSet.getString("buy_address")
                );
                return Order;
            } else {
                return null; // Order not found
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving Order by ID");
        }
    }
    
 // Retrieve all Orders
    public List<Order> getAllOrders() throws DAOException {
        String selectQuery = "SELECT * FROM Order";
        List<Order> OrderList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                Order Order = new Order(
                    resultSet.getLong("id"),
                    resultSet.getLong("product_id"),
                    resultSet.getLong("buyer_id"),
                    resultSet.getString("name"),
                    resultSet.getInt("price"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("url"),
                    resultSet.getDate("order_date").toLocalDate(),
                    resultSet.getString("buy_address")
                );
                OrderList.add(Order);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving all Orders");
        }
        return OrderList;
    }
    
 // Update an existing Order
    public boolean updateOrder(Order Order) throws DAOException {
        String updateQuery = "UPDATE Order SET name = ?, price = ?, quantity = ?, url = ?, order_date = ?, buy_address = ? WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, Order.getName());
            updateStatement.setInt(2, Order.getPrice());
            updateStatement.setInt(3, Order.getQuantity());
            updateStatement.setString(4, Order.getUrl());
            updateStatement.setDate(5, java.sql.Date.valueOf(Order.getorderDate()));
            updateStatement.setString(6, Order.getBuyAddress());
            updateStatement.setLong(7, Order.getProductId());


            int rowsUpdated = updateStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new DAOException("Error updating Order");
        }
    }

    // Delete a Order by its ID
    public boolean deleteOrder(long OrderId) throws DAOException {
        String deleteQuery = "DELETE FROM Order WHERE id = ?";
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
