package com.fssa.rishi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Seller;
import com.fssa.rishi.utils.ConnectionUtil;

public class SellerDAO {

	public boolean createSeller(Seller seller) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO user (email, username, password, phone_number, pincode, address, is_seller, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)")) {

			statement.setString(1, seller.getEmail());
			statement.setString(2, seller.getUsername());
			statement.setString(3, seller.getPassword());
			statement.setLong(4, seller.getPhoneNumber());
			statement.setInt(5, seller.getPincode());
			statement.setString(6, seller.getHomeAddress());
			statement.setInt(7, seller.getIsSeller() ? 1 : 0);
			statement.setLong(8, seller.getId());

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
