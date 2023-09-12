package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Cart;
import com.fssa.rishi.utils.ConnectionUtil;

public class CartDAO {

	public boolean createCartcart(Cart cart) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						INSERT INTO cart_details (product_id, name, price, quantity, url, date, address)
						SELECT id, name, price, quantity, url, CURDATE(), 'default_address'
						FROM product_details;

				) {

			statement.setLong(1, cart.getId());
			statement.setString(2, cart.getName());
			statement.setInt(3, cart.getPrice());
			statement.setInt(4, cart.getQuantity());
			statement.setString(5, cart.getDescription());
			statement.setString(6, cart.getUrl());
			statement.setString(7, cart.getAddress());
			statement.setString(8, cart.getType());
			statement.setString(9, cart.getCity());
			statement.setLong(10, cart.getUserId());
			statement.setInt(11, cart.getPincode());
			statement.setDate(12, Date.valueOf(cart.getUploadDate()));

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
