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

	public boolean createOrder(Order order) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO ordered_details (id, user_id, product_id, name, price, quantity, user_address, district, pincode, ordered_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            System.out.println(order.toString());
			statement.setLong(1, order.getId());
			statement.setLong(2, order.getuser_id());
			statement.setLong(3, order.getproductId());
			statement.setString(4, order.getName());
			statement.setInt(5, order.getPrice());
			statement.setInt(6, order.getQuantity());
			statement.setString(7, order.getUser_address());
			statement.setString(8, order.getDistrict());
			statement.setInt(9, order.getPincode());
			statement.setDate(10, Date.valueOf(order.getordered_date()));

			int rows = statement.executeUpdate();

			return (rows == 1);

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
	            Order order = new Order(
	                resultSet.getLong("id"),
	                resultSet.getLong("user_id"),
	                resultSet.getLong("product_id"),
	                resultSet.getString("name"),
	                resultSet.getInt("price"),
	                resultSet.getInt("quantity"),
	                resultSet.getString("user_address"),
	                resultSet.getString("district"),
	                resultSet.getInt("pincode"),
	                resultSet.getDate("ordered_date").toLocalDate()
	            );

	            orders.add(order);
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error retrieving orders by user ID");
	    }

	    return orders;
	}

//    
// // Retrieve all Orders
//    public List<Order> getAllOrders() throws DAOException {
//        String selectQuery = "SELECT * FROM Order";
//        List<Order> OrderList = new ArrayList<>();
//        try (Connection connection = ConnectionUtil.getConnection();
//             PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
//             ResultSet resultSet = selectStatement.executeQuery()) {
//            while (resultSet.next()) {
//                Order Order = new Order(
//                    resultSet.getLong("id"),
//                    resultSet.getLong("order_id"),
//                    resultSet.getLong("buyer_id"),
//                    resultSet.getString("name"),
//                    resultSet.getInt("price"),
//                    resultSet.getInt("quantity"),
//                    resultSet.getString("url"),
//                    resultSet.getDate("order_date").toLocalDate(),
//                    resultSet.getString("buy_address")
//                );
//                OrderList.add(Order);
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error retrieving all Orders");
//        }
//        return OrderList;
//    }
    
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
