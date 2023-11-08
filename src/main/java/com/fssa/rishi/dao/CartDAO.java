package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Cart;
import com.fssa.rishi.utils.ConnectionUtil;

public class CartDAO {

	public boolean createCart(Cart cart) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO cart (id, user_id, seller_id, product_id, url, name, price, quantity) VALUES(?, ?, ?, ?, ?, ?, ?, ?)")) {
			statement.setLong(1, cart.getId());
			statement.setLong(2, cart.getBuyerId());
			statement.setLong(3, cart.getSellerId());
			statement.setLong(4, cart.getProductId());
			statement.setString(5, cart.getUrl());
			statement.setString(6, cart.getName());
			statement.setInt(7, cart.getPrice());
			statement.setInt(8, cart.getQuantity());

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Retrieve a cart by its ID
	public List<Cart> getCartsByUserId(long userId) throws DAOException {
	    List<Cart> carts = new ArrayList<>(); // Correct ArrayList instantiation

	    String selectQuery = "SELECT * FROM cart WHERE user_id = ?";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
	        selectStatement.setLong(1, userId);
	        ResultSet resultSet = selectStatement.executeQuery();
	        while (resultSet.next()) {
	            // Map each result set row to a Cart object and add it to the list
	            Cart cart = new Cart(
	                    resultSet.getLong("id"),
	                    resultSet.getLong("user_id"),
	                    resultSet.getLong("seller_id"),
	                    resultSet.getLong("product_id"),
	                    resultSet.getString("url"),
	                    resultSet.getString("name"),
	                    resultSet.getInt("price"),
	                    resultSet.getInt("quantity")
	            );
	            carts.add(cart);
	            
	        }
	        if (carts.isEmpty()) {
	            throw new DAOException("There are no products in the own cart");
	        }
	        return carts;
	    } catch (SQLException e) {
	        throw new DAOException("An error occurred while fetching the user's cart");
	    }
	}



	// Update an existing cart
	public boolean updateCart(long id, int qty) throws DAOException {
	    String updateQuery = "UPDATE cart SET quantity = ? WHERE id = ?";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

	        updateStatement.setInt(1, qty);
	        updateStatement.setLong(2, id);
	        int rowsUpdated = updateStatement.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        throw new DAOException("Error updating cart");
	    }
	}


	public boolean checkProductExistOrNot(long productId, long buyerId) throws DAOException {
		String selectQuery = "SELECT product_id FROM cart WHERE product_id = ? AND user_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setLong(1, productId);
			statement.setLong(2, buyerId);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					throw new DAOException("You already added this product to your cart");
				} else {
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	// Get a cart by its id
	public Cart getCartById(long cartId) throws DAOException {
	    String selectQuery = "SELECT * FROM cart WHERE id = ?";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
	        selectStatement.setLong(1, cartId);
	        ResultSet resultSet = selectStatement.executeQuery();

	        if (resultSet.next()) {
	            Cart cart = new Cart(
	                resultSet.getLong("id"),
	                resultSet.getLong("user_id"),
	                resultSet.getLong("seller_id"),
	                resultSet.getLong("product_id"),
	                resultSet.getString("url"),
	                resultSet.getString("name"),
	                resultSet.getInt("price"),
	                resultSet.getInt("quantity")
	            );
	            return cart; // Return the single Cart object
	        } else {
	            return null; // Cart with the specified ID not found
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error fetching cart by ID");
	    }
	}


	// Delete a cart by its ID
	public boolean deleteCart(long id) throws DAOException {
		String deleteQuery = "DELETE FROM cart WHERE id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
			deleteStatement.setLong(1, id);
			int rowsDeleted = deleteStatement.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			throw new DAOException("Error deleting cart by ID");
		}
	}
	
	// Delete a cart by its ID
	public boolean deleteCartByUserId(long userId) throws DAOException {
		String deleteQuery = "DELETE FROM cart WHERE user_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
			deleteStatement.setLong(1, userId);
			int rowsDeleted = deleteStatement.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			throw new DAOException("Error deleting cart by ID");
		}
	}
}
