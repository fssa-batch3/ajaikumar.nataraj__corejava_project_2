package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Cart;
import com.fssa.rishi.utils.ConnectionUtil;

public class CartDAO {

	public boolean createCart(long id) throws DAOException {
		String selectQuery = "SELECT * FROM product_details where id=?";
		String insertQuery = "INSERT INTO cart (id, product_id, buyer_id, name, price, quantity, url, order_date, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = selectStatement.executeQuery();
				PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
			while (resultSet.next()) {
				// Map the columns from the source table to the destination table columns
				insertStatement.setLong(1, resultSet.getLong("id"));
				insertStatement.setLong(2, resultSet.getLong("product_id"));
				insertStatement.setLong(3, resultSet.getLong("buyer_id"));
				insertStatement.setString(4, resultSet.getString("name"));
				insertStatement.setInt(5, resultSet.getInt("price"));
				insertStatement.setInt(6, resultSet.getInt("quantity"));
				insertStatement.setString(7, resultSet.getString("url"));
				insertStatement.setDate(8, resultSet.getDate("order_date"));
				insertStatement.setString(9, resultSet.getString("address"));

				// Execute the insert statement
				insertStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	 // Retrieve a cart by its ID
    public Cart getCartById(long cartId) throws DAOException {
        String selectQuery = "SELECT * FROM cart WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setLong(1, cartId);
            ResultSet resultSet = selectStatement.executeQuery();
            
            if (resultSet.next()) {
                // Map the result set to a Cart object
                Cart cart = new Cart(
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
                return cart;
            } else {
                return null; // Cart not found
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving cart by ID");
        }
    }
    
 // Retrieve all carts
    public List<Cart> getAllCarts() throws DAOException {
        String selectQuery = "SELECT * FROM cart";
        List<Cart> cartList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                Cart cart = new Cart(
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
                cartList.add(cart);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving all carts");
        }
        return cartList;
    }
    
 // Update an existing cart
    public boolean updateCart(Cart cart) throws DAOException {
        String updateQuery = "UPDATE cart SET name = ?, price = ?, " +
                             "quantity = ?, url = ?, order_date = ?, buy_address = ? WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, cart.getName());
            updateStatement.setInt(2, cart.getPrice());
            updateStatement.setInt(3, cart.getQuantity());
            updateStatement.setString(4, cart.getUrl());
            updateStatement.setDate(5, java.sql.Date.valueOf(cart.getorderDate()));
            updateStatement.setString(6, cart.getBuyAddress());
            updateStatement.setLong(7, cart.getProductId());


            int rowsUpdated = updateStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new DAOException("Error updating cart");
        }
    }

    // Delete a cart by its ID
    public boolean deleteCart(long cartId) throws DAOException {
        String deleteQuery = "DELETE FROM cart WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            deleteStatement.setLong(1, cartId);
            int rowsDeleted = deleteStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new DAOException("Error deleting cart by ID");
        }
    }
}
