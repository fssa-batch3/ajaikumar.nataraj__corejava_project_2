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
import com.fssa.rishi.model.Order;
import com.fssa.rishi.utils.ConnectionUtil;

public class CartDAO {

	public boolean createCart(Cart cart) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO cart (id, user_id, product_id, name, price, quantity) VALUES(?, ?, ?, ?, ?, ?)")) {
            System.out.println(cart.toString());
			statement.setLong(1, cart.getId());
			statement.setLong(2, cart.getBuyerId());
			statement.setLong(3, cart.getProductId());
			statement.setString(4, cart.getName());
			statement.setInt(5, cart.getPrice());
			statement.setInt(6, cart.getQuantity());
			

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
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
                    resultSet.getInt("quantity")
                   
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
                    resultSet.getInt("quantity")
                   
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
        String updateQuery = "UPDATE cart SET name = ?, price = ?, quantity = ? WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, cart.getName());
            updateStatement.setInt(2, cart.getPrice());
            updateStatement.setInt(3, cart.getQuantity());
            updateStatement.setLong(4, cart.getProductId());


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
